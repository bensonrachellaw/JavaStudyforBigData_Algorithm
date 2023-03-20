package JZoffers;

import java.util.HashMap;

public class LRU {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCache solution = new LRUCache(capacity);
        solution.put(1, 1); // 缓存是 {1=1}
        solution.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(solution.get(1));    // 返回 1
        solution.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(solution.get(2));    // 返回 -1 (未找到)
        solution.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(solution.get(1));    // 返回 -1 (未找到)
        System.out.println(solution.get(3));    // 返回 3
        System.out.println(solution.get(4));    // 返回 4
    }

    static class LRUCache {
        //双向链表+HashMap
        static class LinkedNode{//双向链表的节点数据结构：双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
            int key;//成员变量
            int value;
            LinkedNode prev;
            LinkedNode next;
            public LinkedNode(){}
            public LinkedNode(int key,int value){//方法的参数为局部变量。局部变量：在方法定义中或者方法声明上。
                this.key= key;//this用来解决重名问题。但是本来区分开的话是不需要的。
                this.value = value;//this用来解决重名问题。
            }
        }

        private final HashMap<Integer,LinkedNode> cache = new HashMap<>();//cache哈希表
        private int size;
        private final int capacity;
        private final LinkedNode head;
        private final LinkedNode tail;//在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
                                     //这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。

        public LRUCache(int capacity){//构造函数
            this.size = 0;//当前容量大小
            this.capacity = capacity;//初始化容量

            head = new LinkedNode();// 使用伪头部和伪尾部节点
            tail = new LinkedNode();

            head.next = tail;//伪头部的next指针指向伪尾部
            tail.prev = head;//伪尾部的prev指针指向伪头部
        }
        //函数 get 方法和 put 方法必须以 O(1) 的平均时间复杂度运行。
        public int get(int key){
            LinkedNode node = cache.get(key);
            if (node == null){
                return -1;
            }
            moveToHead(node);// 如果 key 存在，先通过哈希表定位，再移到头部（说明使用了）
            return node.value;
        }

        public void put(int key,int value){
            if (!cache.containsKey(key)){// 如果 key 不存在，创建一个新的节点
                LinkedNode newNode = new LinkedNode(key,value);
                cache.put(key,newNode);// 添加进哈希表
                addToHead(newNode); // 添加至双向链表的头部
                size++;//当前容量加一
                if (size>capacity){// 如果超出容量，删除双向链表的尾部节点
                    LinkedNode removeNode = removeTail();
                    cache.remove(removeNode.key);// 删除哈希表中对应的项。在hashmap中删除key为***的项。
                    size--;
                }
            }
            else {// 如果 key 存在，先通过哈希表定位，再更新value，并移到头部
                cache.get(key).value = value;
                moveToHead(cache.get(key));
            }
        }
        //想要实现get和put。首先实现四个操作。
        private void addToHead(LinkedNode node){//将一个节点移到双向链表的头部
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void removeNode(LinkedNode node){//将一个节点从双向链表中删除
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //上面两个是基础操作，后两个用前两个基础操作实现
        private void moveToHead(LinkedNode node){
            removeNode(node);//「删除该节点」
            addToHead(node);//「在双向链表的头部添加节点」
//          将一个节点移到双向链表的头部，可拆分成「删除该节点」和「在双向链表的头部添加节点」两步操作，都可以在 O(1) 时间内完成。
        }

        /**
         * 逐出最近最少使用（排在链表的末尾的节点）也就是当内存不够用时，需要逐出最近最少使用的节点。
         */
        private LinkedNode removeTail(){//需要删除哈希表cache中对应的项；所以返回值要为LinkedNode;
            LinkedNode removeNode = tail.prev;
            removeNode(removeNode);//从链表中删除这个节点。
            return removeNode;//需要用来删除哈希表中对应的项。
        }
    }
}
