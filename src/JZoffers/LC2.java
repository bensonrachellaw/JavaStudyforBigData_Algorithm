package JZoffers;

public class LC2 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode tag = ans;
        int jinwei = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + jinwei;
            int res = sum%10;
            jinwei = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            ListNode nxt = new ListNode(res);
            tag.next = nxt;
            tag = tag.next;
        }
        while (l1!=null){
            int sum = l1.val + jinwei;
            int res = sum%10;
            jinwei = sum/10;
            l1 = l1.next;
            ListNode nxt = new ListNode(res);
            tag.next = nxt;
            tag = tag.next;
        }
        while (l2!=null){
            int sum = l2.val + jinwei;
            int res = sum%10;
            jinwei = sum/10;
            l2 = l2.next;
            ListNode nxt = new ListNode(res);
            tag.next = nxt;
            tag = tag.next;
        }
        if (jinwei==1){//注意最后的进位。不能忽略。
            ListNode nxt = new ListNode(1);
            tag.next = nxt;
        }
        return ans.next;
    }
}
