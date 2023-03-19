package JZoffers;

import java.util.LinkedList;
import java.util.Queue;

public class NK_NC198 {
//    判断是不是完全二叉树
     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;
         public TreeNode(int val) {
           this.val = val;
         }
   }
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if (root==null) return true;
        boolean tag = false;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if (node==null) {
                tag = true;
                continue;
            }
            if (tag) return false;
            que.offer(node.left);
            que.offer(node.right);
        }
        return true;
    }
    /**
     * BFS层序遍历中第一次看到null就让tag=true（标记），表示所有非null的node都遍历完了。 那么之如果再见到非null的node那么tree就不是完全二叉树。
     */
}
