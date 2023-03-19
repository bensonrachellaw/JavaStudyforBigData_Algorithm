package ZJCampus;

public class DaySixteen2 {
    public static void main(String[] args) {

    }

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

    static class Solution {
        long ans = 0;
        public int sumNumbers(TreeNode root) {
            find("",root);
            return (int)ans;
        }

        private void find(String s,TreeNode node){
            if (node.left==null && node.right==null) {
                long res = Long.parseLong(s+node.val+"");//字符串转int或者long
                ans += res;
                return;
            }
            String x = node.val+"";//int转字符串
            if(node.left!=null) find(s+x,node.left);
            if(node.right!=null) find(s+x,node.right);
        }
    }
}
