package ZJCampus;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DayTen1 {
    static List<Integer> list ;
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
    public static void mid_ord(TreeNode node){//递归法
        if (node==null){
            return;
        }
        mid_ord(node.left);
        list.add(node.val);
        mid_ord(node.right);
    }
    /**
     * 颜色标记法，或者说类型标记法
     * 前序遍历：中，左，右
     * 中序遍历：左，中，右
     * 后序遍历：左，右，中
     * 入栈顺序为逆序。测试过。Lc144、Lc145
     * 可以按照代码来模拟一遍来理解这个方法。相当于每个节点都要入栈两次，第二次才是真正记录node的val。
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Deque<Object> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        if (root==null) return list;
        stack.push(root);
        while (!stack.isEmpty()){
            Object item = stack.pop();
            if (item instanceof Integer){
                list.add((Integer) item);
            }
            else {//如要实现前序、后序遍历，只需要调整左右子节点的入栈顺序即可。
                //因为中序遍历是左节点--根节点--右节点
                //即出栈顺序为左节点--根节点--右节点，入栈顺序相反
                TreeNode node = (TreeNode) item;
                if (node.right!=null){
                    stack.push(node.right);
                }
                stack.push(node.val);
                if (node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        return list;
    }
}
