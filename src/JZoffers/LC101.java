package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/3
 */
public class LC101 {
    public static void main(String[] args) {

    }
    public static class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return checkIfSymmetric(root.left,root.right);
    }
    public boolean checkIfSymmetric(TreeNode left,TreeNode right) {
        if (left==null || right==null) return left==null && right==null;//判断两个都是空的话就返回真，其他都是假。
        return left.val == right.val && checkIfSymmetric(left.left,right.right) && checkIfSymmetric(left.right,right.left);
        //不空但是值不相等也为假。到这里说明两颗树的根节点一样，然后就判断左的左和右的右并且左的右和右的左是否为真。
    }
}
