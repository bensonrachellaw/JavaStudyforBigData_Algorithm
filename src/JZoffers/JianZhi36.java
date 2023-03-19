package JZoffers;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/14
 * 牛客版本（首尾不用相连），leetcode版本（首尾也要相连）在小米的笔试题第二题
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */
public class JianZhi36 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    TreeNode pre=null;//中序遍历当前值的上一位
    TreeNode head=null;//当前双向链表第一个节点
    public TreeNode Convert(TreeNode root) {//root是当前节点
        if(root == null) return null;//中序递归，叶子为空则返回
        Convert(root.left); //首先递归到最左（最小值）
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if(pre == null) head = root; //找到最小值，初始化head
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
        else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;//保存当前节点，用于下层递归创建
        Convert(root.right);
        return head;
    }
}
