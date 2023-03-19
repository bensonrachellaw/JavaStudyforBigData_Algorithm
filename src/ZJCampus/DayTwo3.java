package ZJCampus;

public class DayTwo3 {
    int max = Integer.MIN_VALUE;

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
    public int maxPathSum(TreeNode root) {
        maxRecursion(root);
        return max;
    }

    public int maxRecursion(TreeNode recursionRoot){
        if (recursionRoot == null){
            return 0;
        }

        int leftMax = Math.max(0,maxRecursion(recursionRoot.left));//*
        int rightMax = Math.max(0,maxRecursion(recursionRoot.right));//*


        max = Math.max(max,recursionRoot.val + leftMax + rightMax);
        //自己与自己的左右单独成一条路径(左->自己->右)，是有可能成为最终答案的。

        return recursionRoot.val + Math.max(leftMax,rightMax);
        //自己与自己的左或右组成别人的路径的一部分（所以只能只能选左或右，或者都不选。绝对不能两个都选）。
        //返回自己作为根节点（路径从下到上自己作为最终节点）的路径最大值来提供给自己的上一层（父节点），
        //成为父节点的左最大值或者右最大值(返回给*号位置)
    }
}
