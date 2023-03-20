package ZJCampus;

public class DaySeventeen1 {
    //环形链表。

    public static void main(String[] args) {

    }
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }
     /*
        为什么我们要规定初始时慢指针在位置 head，快指针在位置 head.next，而不是两个指针都在位置 head（即与「乌龟」和「兔子」中的叙述相同）？
        观察下面的代码，我们使用的是 while 循环，循环条件先于循环体。由于循环条件一定是判断快慢指针是否重合，
        如果我们将两个指针初始都置于 head，那么 while 循环就不会执行。
        因此，我们可以假想一个在 head 之前的虚拟节点，慢指针从虚拟节点移动一步到达 head，快指针从虚拟节点移动两步到达 head.next，这样我们就可以使用 while 循环了。
     */
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;

        while (first != second){
            if (second == null || second.next==null){
                return false;
            }
            first = first.next;
            second = second.next.next;
        }
        return true;
    }

}
