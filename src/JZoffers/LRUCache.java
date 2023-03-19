package JZoffers;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        int capacity = 2;
        Lrucache solution = new Lrucache(capacity);
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

    public static class Lrucache extends LinkedHashMap<Integer, Integer>{//“Java接口里定义的内部类默认使用public static修饰 ,且只能指定public作为访问控制符
        private int capacity;

        public Lrucache(int capacity){
            super(capacity,0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {//这个参数不太明白为什么需要，去查了api文档，人家已经写死了，你重写又不能改变参数。
            return size() > capacity;
        }

        public int get(int key){
            return super.getOrDefault(key,-1);
        }

        public void put(int key,int value){
            super.put(key, value);
        }

    }
}
