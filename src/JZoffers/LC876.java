package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/28
 */
public class LC876 {
    public ListNode middleNode(ListNode head) {//快慢指针法：如果有两个中间节点，则返回第2个中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode findMidNode(ListNode head){//如果有两个中间节点，则返回第1个中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

