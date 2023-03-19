package JZoffers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/19
 */
//《求二叉树的深度》
public class LC104 {
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
    public int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,1);
        return max;
    }
    private void dfs(TreeNode node,int k) {
        if (node==null) {
            max = Math.max(max,k-1);
            return;
        }
        dfs(node.left,k+1);
        dfs(node.right,k+1);
    }
    public int maxDepth_bfs(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //每次都拿出一层所有节点。
            for (int i = 0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            max++;
        }
        return max;
    }

}
