package ZJCampus;

import java.util.ArrayList;

public class DayOne3 {
    public static void main(String[] args) {

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;
        while(head != null){
            ListNode tail = prev;
            // 查看剩余部分长度是否大于等于 k，剩余k不反转。双闭的区间。
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode[] arr = reverseList(head,tail);
            prev.next = arr[0];//头的前一个（perv）接上反转后的头。
            head = arr[1].next;
            tail = arr[1];
            prev = arr[1];
        }
        ArrayList<Integer> list = new ArrayList<>();
        return hair.next;
    }

    //a如果赋值为tail.next,a在后面变了，tail.next也会变。
    //但是如果a赋值为一个节点（设作x），则a变的时候x不会变。

    public ListNode[] reverseList(ListNode head,ListNode tail){
        //remain second(两个指针的相对位置)
        ListNode remain = tail.next;//tail后面那堆。反转后得接上。
        ListNode second = head;
        ListNode tag = tail.next;//固定住tail.next。
        while(second != tag){
            ListNode temp_second = second.next;
            second.next = remain;
            remain = second;
            second = temp_second;
        }
        ListNode[] arr = new ListNode[]{remain,head};//{反转后的头、尾}
        return arr;
    }
}
