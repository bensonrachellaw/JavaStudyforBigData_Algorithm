package JZoffers;

import java.util.*;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/1
 */
public class LC114 {
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
//    暴力前序遍历记录下来再组合法
    public static ArrayList<TreeNode> list = new ArrayList<>();
    public static void flatten(TreeNode root) {
        if (root==null) return;
        if (root.left == null && root.right == null) return;
        TreeNode node = root;
        dfs(node);
        int i = 1;
        while (i<list.size()){
            root.right = list.get(i);
            i++;
            root.left = null;
            root = root.right;
        }
    }
    public static void dfs(TreeNode node) {
        list.add(node);
        if (node.left!=null) dfs(node.left);
        if (node.right!=null) dfs(node.right);

    }
    //新方法：原地修改，空间复杂度O(1) in-place。

    /**
     * 找左子树最右边的节点
     * 将原来的右子树接到左子树的最右边节点
     * 将左子树插入到右子树的地方
     * 然后考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     *
     * 此方法还有递归写法（评论第一的写法），也就是按照前序遍历的逆序来，前序遍历是根-左-右。所以逆序是右-左-根
     * @param root
     */
    public void flatten2(TreeNode root) {
        while (root!=null){
            if (root.left ==null) root = root.right;//左子树为 null，直接考虑下一个节点
            else {
                TreeNode rightmostInLeft = root.left;// 找左子树最右边的节点
                while (rightmostInLeft.right!=null) rightmostInLeft = rightmostInLeft.right;
                rightmostInLeft.right = root.right; //将原来的右子树接到左子树的最右边节点
                root.right = root.left;// 将左子树插入到右子树的地方
                root.left = null;//左子树置空

                root = root.right;  // 迭代考虑下一个节点
            }
        }
    }

}
