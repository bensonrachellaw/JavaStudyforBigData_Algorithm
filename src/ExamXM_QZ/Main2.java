package ExamXM_QZ;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/14
 * LC-JZ36：二叉搜索树与双向链表（首尾也要相连）：https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 牛客（首尾不用相连）：https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */

public class Main2 {
    public static void main(String[] args) {

    }
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    class Solution {
        Node pre=null;//中序遍历当前值的上一位
        Node head=null;//当前双向链表第一位
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            inOrderdfs(root);//inOrderdfs走完之后，pre是整个的最后节点，head是第一个
            // 题目要求头尾连接
            head.left = pre;
            pre.right = head;

            return head;

        }
        //这个函数对应解决牛客的JZoffer-36题（首尾不用相连）
        private void inOrderdfs(Node root){
            if(root == null) return;//中序递归，叶子为空则返回
            inOrderdfs(root.left); //首先递归到最左（最小值）
            // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
            if(pre == null) head = root; //找到最小值，初始化head
                // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
                // 让上一个节点的右指针指向当前节点
            else {
                pre.right = root;
                root.left = pre;
            }
            pre = root;//保存当前节点，用于下层递归创建
            inOrderdfs(root.right);
        }
    }


}
