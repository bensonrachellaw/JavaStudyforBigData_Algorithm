package ExamTME_QZ;

import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/8
 *
 * 题目描述:
 * 已知一个二叉树的先序遍历序列和中序遍历序列，但其中一些节点的值可能相同。
 * 请你返回所有满足条件的二叉树。二叉树在数组中的顺序是任意的。
 *
 * 因为有相同的,所以在中序遍历中，要枚举可能成为根节点的节点，比如两个1，就要遍历这两个1，然后产生不同的情况。
 *
 * input:
 * [1,1,2],[1,2,1]
 *
 * output:
 * [{1,1,#,#,2｝,{1,#,1,2｝]
 *
 *
 * LC105改编,如果节点数有重复。已知先序，中序，是可以确定唯一一颗二叉树的（在节点值，preorder 和 inorder 均 无重复 元素的情况下）
 */
public class Main2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println();
    }
    public static ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        return buildTree(preOrder, 0, preOrder.size() - 1,
                inOrder, 0, inOrder.size() - 1);
    }

    public static ArrayList<TreeNode> buildTree (ArrayList<Integer> preOrder,int preorder_left, int preorder_right, ArrayList<Integer> inOrder, int inorder_left, int inorder_right) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (preorder_left > preorder_right) {
            ans.add(null);
            return ans;
        }

        int rootVal= preOrder.get(preorder_left);

        ArrayList<Integer> rootList = new ArrayList<>();
        for (int i = inorder_left ; i<= inorder_right ;i++) {
            if (inOrder.get(i)==rootVal) {
                rootList.add(i);//获取在中序遍历中可能成为根节点的节点的下标。
            }
        }

        for (int index : rootList) {
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素

            ArrayList<TreeNode> left = buildTree(preOrder,preorder_left+1,preorder_left + index - inorder_left ,inOrder,inorder_left,index - 1);

            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            ArrayList<TreeNode> right = buildTree(preOrder,preorder_left + index - inorder_left + 1,preorder_right,inOrder,index+1,inorder_right);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode rootNode = new TreeNode(rootVal);
                    rootNode.left = lnode;
                    rootNode.right = rnode;
                    ans.add(rootNode);
                }
            }

        }
        return ans;

    }

}
