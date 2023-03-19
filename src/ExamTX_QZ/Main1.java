package ExamTX_QZ;

import ZJCampus.DayThree1;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/10/16
 */
public class Main1 {

    public class ListNode {
         int val;
         ListNode next = null;
         public ListNode(int val) {
           this.val = val;
         }
    }
    public static void main(String[] args) {

    }

    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        ListNode ar = reverseList(a);
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        while (ar!=null && b != null) {
            int val = (ar.val) ^ (b.val);
            ListNode node = new ListNode(val);
            p.next = node;
            p = p.next;
            ar = ar.next;
            b = b.next;
        }
        while (b==null && ar!=null) {
            int val1 = (ar.val) ^ (0);
            ListNode node = new ListNode(val1);
            p.next = node;
            p = p.next;
            ar = ar.next;
//            b = b.next;
        }
        while (b!=null && ar==null) {
            int val2 = (0) ^ (b.val);
            ListNode node = new ListNode(val2);
            p.next = node;
            p = p.next;
//            ar = ar.next;
            b = b.next;
        }
        ListNode res = reverseList(ans.next);
        return res;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
