package ExamHW;

import java.util.Deque;
import java.util.LinkedList;

public class LC654 {
    //最大二叉树：递归和单调栈解法两种
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
    //递归法：官方题解的评论给出一个单调栈解法。
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return solution(nums,0,nums.length-1);
        }

        public TreeNode solution (int[] nums,int l ,int r){
            if (l>r) return null;
            int max_index = count(nums,l,r);
            TreeNode node  = new TreeNode(nums[max_index]);
            node.left = solution(nums,l,max_index-1);
            node.right = solution(nums,max_index+1,r);
            return node;
        }

        public int count(int[] nums,int l ,int r){
            int max = -1;
            int ans = -1;
            for(int i = l;i<=r;i++){
                if (nums[i]>max) {
                    max = nums[i];
                    ans =  i;
                }
            }
            return ans;
        }
        //单调栈解法
        public TreeNode constructMaximumBinaryTree_DDZ(int[] nums) {
            Deque<TreeNode> stack = new LinkedList<>();
            for (int i = 0;i<nums.length;i++){
                TreeNode node = new TreeNode(nums[i]);
                while (!stack.isEmpty() && node.val > stack.peek().val){
                    TreeNode tmp = stack.pop();
                    if (!stack.isEmpty() && node.val > stack.peek().val) {
                        // TreeNode tmp2 = stack.pop();
                        // tmp2.right = tmp;
                        // stack.push(tmp2);
                        stack.peek().right = tmp;//这样可以的，不用拿出来处理完再放回去。
                    }
                    else {
                        node.left = tmp;
                    }
                }
                stack.push(node);
            }
            TreeNode temp = stack.peek();
            while (!stack.isEmpty()) {
                temp = stack.pop();
                if (!stack.isEmpty()){
                    // TreeNode temp1 = stack.pop();
                    // temp1.right = temp;
                    // stack.push(temp1);
                    stack.peek().right = temp;
                }
            }
            return temp;
        }
    }




}
