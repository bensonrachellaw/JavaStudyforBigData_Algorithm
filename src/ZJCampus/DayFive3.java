package ZJCampus;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DayFive3 {
    public static void main(String[] args) {



    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);//小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1,v2) -> v1.val - v2.val);
        PriorityQueue<ListNode> pq2 = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        PriorityQueue<ListNode> pq3 = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

          //四种方式都能实现升序的优先队列。
          //所以更多时候我们是直接记住了compare（int o1, int o2）方法 return o1 - o2 是升序，return o2 - o1 是降序。那么原因我们不妨跳进去源码看一下.
        for (ListNode node : lists){
            if (node!=null){
                que.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!que.isEmpty()){
            ListNode node = que.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next!=null){
                que.offer(node.next);
            }
        }
        return dummy.next;
    }

    public static ListNode mergeKLists1(ListNode[] list){
        if (list.length==0) return null;
        return merge(list,0,list.length-1);
    }

    public static ListNode merge(ListNode[] list,int l,int r){
        if (l==r){
            return list[l];
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(list,l,mid),merge(list,mid+1,r));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        while(list1!=null && list2!=null){
            ListNode temp;
            if(list1.val <= list2.val){
                temp = new ListNode(list1.val);
                ans.next = temp;
                list1 = list1.next;
            }
            else{
                temp = new ListNode(list2.val);
                ans.next = temp;
                list2 = list2.next;
            }
            ans = temp;
        }

        ans.next = list1 == null ? list2 : list1;
        return head.next;
    }

}
