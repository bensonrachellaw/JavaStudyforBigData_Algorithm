package ZJCampus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DayTen2 {
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
    //BFS 二叉树的层次遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){return ans;}
        que.add(root);
        que.add(null);//每行（层）的结尾标识符

        List<Integer> temp = new LinkedList<>();
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            if (node!=null){
                temp.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            else {
                ans.add(new ArrayList<>(temp));//一定要拷贝一份的。
                if (!que.isEmpty()) que.add(null);
                temp.clear();
                /*下面的也OK。
                ans.add(temp);
                if (!que.isEmpty()) que.add(null);
                temp = new LinkedList<>();
                */
            }
        }
        return ans;
    }

    //DFS 使用递归做。在递归时要记录每个节点的深度 level
    //增加一个level参数表明当前在哪一层。
    public static List<List<Integer>> res = new ArrayList<>();//用来存放最终结果

    public static List<List<Integer>> levelOrder_re(TreeNode root){
        if (root==null) return res;
        dfs(root,0);
        return res;
    }
    //这是一个前序遍历，这里其实前中后序都是可以的，只要保证先遍历左子树再遍历右子树就行。
    public static void dfs(TreeNode node , int level){
        if (res.size()-1<level) {
            res.add(new ArrayList<>());//当遍历到一个新的深度 level，而最终结果 res 中还没有创建 level 对应的列表时，应该在 res 中新建一个列表用来保存该 level 的所有节点（这一层的）。
        }
        res.get(level).add(node.val);
        if(node.left!=null) dfs(node.left,level+1);
        if(node.right!=null) dfs(node.right,level+1);

    }
}
