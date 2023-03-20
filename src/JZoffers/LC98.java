package JZoffers;

public class LC98 {
    public static void main(String[] args) {

    }
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
    //二叉搜索数是左子树<节点<右子树
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode node,long min,long max){//递归，增加两个参数，是最小值和最大值，判断每个节点是否满足在这两个值之间，只要有一个不满足就不是二叉搜索树。
        if (node==null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left,min,node.val) && isValid(node.right,node.val,max);
    }

}
