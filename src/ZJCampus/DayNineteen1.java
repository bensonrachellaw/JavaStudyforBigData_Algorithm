package ZJCampus;

public class DayNineteen1 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        if (headA==null || headB==null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=p2){
            p1 = (p1==null ? headB : p1.next);
            p2 = (p2==null ? headA : p2.next);
        }
        return p1;
    }
}
