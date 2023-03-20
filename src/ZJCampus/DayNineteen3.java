package ZJCampus;

public class DayNineteen3 {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        //找入口节点就不能使用像141判断是否存在环的做法那样设置一个虚拟节点了。
        while(p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2==null || p2.next==null) return null;
            if (p1==p2){
                p1 = head;
                while(p1!=p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}

