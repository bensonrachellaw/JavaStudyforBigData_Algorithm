package Algorithms;

/**
 * Description: JavaStudyforBigData_Algorithm
 * Created by L6BD610_Luo on 2023/3/23
 */
public class 二叉树的直径 {

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
    public static void main(String[] args) {

    }
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,left + right);

        return Math.max(left,right) + 1;//选最大的一边加上本节点的1作为最长的路径，返回上一层提供给上一层的节点，组成上一层节点的直径。
    }
}
