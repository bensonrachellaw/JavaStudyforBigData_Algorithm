package ZJCampus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DayThree2 {

    public static void main(String[] args) {

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        //LinkedList 可以用作栈、队列和双向队列
        //poll()peek()都是适用于用Queue定义的LinkedList
        //基于BFS设立结束符的做法，来达到区分每层
        //用LinkedList 和 ArrayList 作为层次遍历BFS队列的数据结构都是可以的。
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null){return ans;}
        que.add(root);
        que.add(null);

        while(!que.isEmpty()){
            TreeNode out = que.poll();
            if(out!=null){
                if(out.left!=null){
                    que.add(out.left);
                }
                if(out.right!=null){
                    que.add(out.right);
                }
                if(que.peek()==null){//说明遇到结束符，遇到上一行的结束符说明下一行的元素全部进入队列了。所以就可以输出这一行的最后这个节点的val并且给这一行加入结束符。
                    ans.add(out.val);
                    que.add(null);
                }
            }
        }
        return ans;
    }
    List<Integer> res = new ArrayList<>();//全局的结果列表。
    public List<Integer> rightSideView_dfs(TreeNode root) {
        dfs(root,0);
        return res;
    }
    //按照 「根结点 -> 右子树 -> 左子树」 的顺序访问， 就可以保证每层都是最先访问最右边的节点的。
    //每层都取最右边的一个(就一个），因此res列表的长度就是二叉树有多少层。
    //然后二叉树是从第0层开始的，所以当当前节点的深度等于res列表现有节点值的个数时，说明当前节点是当前新的层的最右边的节点，是当前层第一个遍历到的节点。
    //比如，当遍历到第五层的第一个时，如果此时res队列的长度为5（第0，1，2，3，4层的最右节点已经放入），那么现在这个第五层的第一个节点的值就是最右边的，所以要加入res。
    private void dfs(TreeNode node,int depth){
        if (node == null) return;
        if (depth==res.size()) res.add(node.val);
        dfs(node.right,depth+1);
        dfs(node.left,depth+1);
    }
}
