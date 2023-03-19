package JZoffers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/17
 */
public class LC1673 {
    public static void main(String[] args) {

    }
    public int[] mostCompetitive(int[] nums, int k) {
        //这道题跟之前做过的LC402(移掉 K 位数字)的思路一模一样甚至还少了一个去掉前缀0的步骤
        int n = nums.length;
        int m = n-k;
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(nums[0]);
        for (int i = 1;i<n;i++){
            while (!stack.isEmpty() && stack.peekLast() > nums[i] && m > 0){
                stack.pollLast();
                m--;
            }
            stack.offer(nums[i]);
        }
        while (m>0){
            stack.pollLast();
            m--;
        }

        int[] ans = new int[k];
        int i = 0;
        while (!stack.isEmpty()){
            ans[i] = stack.pollFirst();
            i++;
        }
        return ans;
    }
}
