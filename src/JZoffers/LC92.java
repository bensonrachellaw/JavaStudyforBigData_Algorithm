package JZoffers;
//反转链表2：
public class LC92 {
    //头插法，不断把后面的往前面塞。当前节点的下一个节点调整为前驱节点的下一个节点，第一个要反转的节点就是当前节点，但是这个节点本身不会变，而位置是逐步往后移，节点还是这个节点。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;// 初始化指针，pre是第一个要反转的节点的前面一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;// 初始化指针，cur是第一个要反转的节点

        for (int i = 0; i < right - left; i++) {//反转三个节点需要头插两次。模拟可知。https://leetcode.cn/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
            ListNode next = cur.next;//先把cur后面的暂时保存，不然会丢失，这个next是要头插到前面的节点。
            cur.next = cur.next.next;//这一步等于直接将cur当前的下一个节点删除，但是不怕，在上一步已经进行暂存，然后cur的next指针直接指向后面隔一个的节点，也就是cur.next.next;
            next.next = pre.next;//把第一步保存的next节点的next指针指向此时的头部（不是pre，是pre.next），也就是第一个要反转的节点的位置的节点。
            pre.next = next;//然后pre的next再连接next，完成一次头插！！！！！！！
        }
        return dummyNode.next;
    }
    //直观的思路比如容易想，找到要反转的段反转，然后把首尾连接上，需要记录各种前后节点。反转 left 到 right 部分以后，再拼接起来。我们还需要记录 left 的前一个节点，和 right 的后一个节点。如图所示：
    public ListNode reverseBetween_1(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1,head); // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode p1 = dummyNode;
        ListNode p2 = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0;i < left - 1 ;i++) {//移到 left 的前驱
            p1 = p1.next;
        }
        // 第 2 步：从 虚拟头节点 走 right 步，来到 right 节点
        for (int i = 0;i < right ;i++) {//移到 right
            p2 = p2.next;
        }
        // 第 3 步：切断出一个子链表（截取链表）
        ListNode start = p1.next;
        ListNode next = p2.next;

        p2.next = null;// 注意：切断链接

        p1.next = reverseList(start);
        start.next = next;// 第 5 步：反转链表 , 接回到原来的链表中

        return dummyNode.next;//因为头节点有可能发生变化，使用虚拟头节点的next返回
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
}
