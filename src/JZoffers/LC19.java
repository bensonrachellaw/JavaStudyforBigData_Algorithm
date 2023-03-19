package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/11
 * LC19《删除链表的倒数第 N 个结点》
 */
public class LC19 {
    public static void main(String[] args) {

    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 其实要找到倒数第n个节点的前序节点才能把倒数第n个节点删去。
        ListNode dummy = new ListNode(0,head);//哑指针，dummy.next = head
        ListNode fast = head;//快指针一开始在链表头节点的位置
        ListNode slow = dummy;//慢指针一开始在哑指针的位置
        for(int i = 0;i<n;i++){//快指针先走n步，这样快慢指针就相差n个节点
            fast = fast.next;
        }
        while(fast!=null){//再快慢指针同时走，直到快指针走到null时退出循环，也就是最后一个节点的下一个节点（null），
            // 这样这个时候快慢相差n个节点，所以慢指针就会在倒数第n个节点的前序节点的位置，方便把倒数第n个节点删去。
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;//把倒数第n个节点删去。
        return dummy.next;
    }
}
