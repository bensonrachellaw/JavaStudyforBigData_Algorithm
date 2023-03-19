package ZJCampus;

public class DayOne1 {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //增加一个头节点。
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();//head和ans可替换
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
        ans.next = list1 == null ? list2 : list1;//一句话搞定。
        return head.next;
    }
}
