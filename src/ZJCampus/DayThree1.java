package ZJCampus;

public class DayThree1 {
    public static void main(String[] args) {
        //反转链表；
        System.out.println();
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }
    /*
        分割+反转+重新拼接(空间复杂度O(1))
        1.利用快慢指针将链表分割成两部分
        2.反转后半部分
        3.交错拼接两部分链表
         */

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
