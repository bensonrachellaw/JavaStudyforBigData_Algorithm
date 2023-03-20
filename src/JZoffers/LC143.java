package JZoffers;

import ZJCampus.DayThree1;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/28
 * 寻找链表中点 + 链表逆序 + 合并链表
 */
public class LC143 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        ListNode mid = findMidNode(head);
        ListNode reverseHead = reverseList(mid.next);//反转后半段
        mid.next = null;//这句必须的，因为要把前半段的最后一个节点，也即是mid指向的节点的next置为null。这样后面才可以判断。这样才算独立且完整的两段。
        ListNode head1 = head;//原本以为这里不能直接用head。因为这样会改变head。要用一个指针指向head
        //但是直接用head也行
        mergeNode(head1,reverseHead);
    }
    // LeetCode 876 但是返回第一个中间节点
    private ListNode findMidNode(ListNode head){//如果有两个中间节点，则返回第一个中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {//fast.next != null 成立，才会有后面的fast.next.next
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // LeetCode 206 翻转链表。这里参数进去的head的next会被修改变为null
    private ListNode reverseList(ListNode head) {
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
    //合并两个链表。将翻转后的后半段一个一个塞到前半段的每个间隙。这题重点是这里！！！怎么合并，看视频 https://leetcode.cn/problems/reorder-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-143-z-4kmk/
    private void mergeNode (ListNode head1,ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }
}
