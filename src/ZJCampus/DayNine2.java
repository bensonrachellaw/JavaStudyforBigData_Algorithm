package ZJCampus;

import java.util.*;

public class DayNine2 {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){return ans;}
        que.add(root);
        que.add(null);

        int tag = 0;
        List<Integer> temp = new LinkedList<>();
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            if (node!=null){
                temp.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            else {
                if (tag==0){
                    ans.add(new LinkedList<>(temp));
                    if (!que.isEmpty()) que.add(null);
                    tag = 1;
                    temp.clear();
                }
                else {
                    Collections.reverse(temp);
                    ans.add(new LinkedList<>(temp));
                    if (!que.isEmpty()) que.add(null);
                    tag = 0;
                    temp.clear();
                }
            }
        }
        return ans;
    }
}
