package ZJCampus;

public class DaySeventeen2 {
    public static void main(String[] args) {

    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null) return right;//p和q分布在了当前根的某一边的子树上
        if (right==null) return left;//p和q都存在同一棵子树上，那么第一个找到的点(p或q)就是最后的答案。
        return root;//如果在左右子树分别找到了p和q,都不等于null，则说明root是它们两个的最近公共祖先。
    }
}
