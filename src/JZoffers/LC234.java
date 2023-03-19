package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/18
 */
public class LC234 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
   //官方答案：快慢指针。快慢指针找到中点再反转后半部分再一一比较的方法。
    public boolean isPalindrome(ListNode head){
        if (head==null) return true;
        ListNode midNode = findMidNode(head);
        ListNode reverseNode = reverseList(midNode.next);
        ListNode pre = head;
        while (reverseNode!=null){
            if (pre.val != reverseNode.val) return false;
            pre = pre.next;
            reverseNode = reverseNode.next;
        }
        return true;
//        // 还原链表并返回结果
//        midNode.next = reverseList(reverseNode);
    }
    private ListNode reverseList(ListNode head) {
        ListNode remain = null;
        ListNode second = head;
        while(second != null){
            ListNode temp_second = second.next;
            second.next = remain;
            remain = second;
            second = temp_second;
        }
        return remain;
    }

    private ListNode findMidNode(ListNode head){//如果有两个中间节点，则返回第一个中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
