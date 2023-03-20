package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/30
 * 快排做法,自己想的
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        quicksort(dummy,null);//prev是链表第一个节点的前一个，end是当前链表最后一个节点的后一个。
        return dummy.next;
    }
    private void quicksort(ListNode prev,ListNode end) {//prev是链表第一个节点的前一个，end是当前链表最后一个节点的后一个。
        if (prev.next==end || prev.next.next==end) return;//prev和end之间没有或者只剩一个都不要再排序了
        ListNode pivot = findMidNode(prev.next,end);

        //交换pivot的下一个到前面（prev.next）：每次选中间的一个节点作为划分点，才能不超时，如果每次都是选第一个作为划分点，就会超时。
        ListNode tempNode = pivot.next;
        pivot.next = pivot.next.next;
        tempNode.next = prev.next;
        prev.next = tempNode;
        //交换完毕

        ListNode cur = prev.next;//当前的划分点
        ListNode p = prev.next;//遍历指针

        while (p.next!=end) {//核心，参照了头插法和指针移动
            if (p.next.val<cur.val) {//划分点后的每个节点与当前的划分点比较，如果小，则是需要移到cur前面，用头插法，这一步不能移动p指针。
                ListNode next = p.next;//先把p后面的暂时保存，不然会丢失，这个next是要头插到前面的节点。
                p.next = p.next.next;//这一步等于直接将p当前的下一个节点删除，但是不怕，在上一步已经进行暂存，然后p的next指针直接指向后面隔一个的节点，也就是p.next.next;
                next.next = prev.next;//把第一步保存的next节点的next指针指向此时的头部（不是prev，是prev.next），也就是当前链表第一个节点的位置的节点。
                prev.next = next;//然后prev的next再连接next，完成一次头插！！！！！！！
            }
            else {//else是必须的！如果大，则是不用动（头插），但是遍历指针得往后移，表示这次的p.next不用动（头插），跟在cur后面就行。
                p = p.next;
            }
        }
        quicksort(prev,cur);//分治
        quicksort(cur,end);//分治
    }
    private ListNode findMidNode(ListNode head,ListNode end){//如果有两个中间节点，则返回第一个中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != end && fast.next.next != end) {//fast.next != null 成立，才会有后面的fast.next.next
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
