package JZoffers;

import java.util.Random;

public class LC382 {
    public static void main(String[] args) {

    }
}
//水塘抽样 水塘抽样由于空间小，时间复杂度低，可以用于大数据流中的随机抽样问题。https://labuladong.gitee.io/algo/4/32/119/
//第 i 个元素被选择的概率是 1/i，第 i+1 次不被替换的概率是 1 - 1/(i+1)，以此类推，相乘就是第 i 个元素最终被选中的概率，就是 1/n。
class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
class Solution {
    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int res = 0;
        int i = 0;
        ListNode node = head;
        while(node != null){
            if (random.nextInt(i+1)==i){//左闭右开.
                res = node.val;
            }
            node = node.next;
            i++;
        }
        return res;
    }
}

/**
 * 如果是要随机选择k个数，只要在第 i 个元素处以 k/i 的概率选择该元素，以 1 - k/i 的概率保持原有选择即可。
 * 第一步：前 k 个元素先默认选上。
 * 第二步：此时i>k,从random.nextInt(i+1)中选择一个随机数rand，如果rand<=k,则把rand的下标的原来的数替换成i位置上的数，
 * 如果rand>k,保留之前的样本集合，继续遍历。
 */


