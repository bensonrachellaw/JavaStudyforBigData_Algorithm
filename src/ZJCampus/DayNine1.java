package ZJCampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * TME02为 此题LC105的改编,如果节点数有重复。已知先序，中序，是可以确定唯一一颗二叉树的（在节点值，preorder 和 inorder 均 无重复 元素的情况下）
 */
public class DayNine1 {
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
    public static HashMap<Integer,Integer> map = new HashMap<>();
    // 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。
    // 我们可以考虑使用哈希表来帮助我们快速地定位根节点。
    // 对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。

    public static TreeNode buildTree(int[] pre,int[] in){
        int n = pre.length;
        for (int i = 0;i<n;i++){
            map.put(in[i],i);
        }
        return build(pre,in,0,n-1,0,n-1);
    }

    public static TreeNode build(int[] pre,int[] in,int l_start,int l_end,int r_start,int r_end){
        if (r_start>r_end){//用前序或者中序判断是否还有值都行。
            return null;
        }
        TreeNode node = new TreeNode(pre[l_start]);
        int in_root = map.get(pre[l_start]);// 在中序遍历中定位根节点
        int sizeLeftSubtree = in_root - r_start;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素

        node.left = build(pre,in,l_start+1,l_start + sizeLeftSubtree,r_start,in_root-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素

        node.right = build(pre,in,l_start+sizeLeftSubtree+1,l_end,in_root+1,r_end);
        return node;
    }
}
