package Algorithms;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData_Algorithm
 * Created by L6BD610_Luo on 2023/3/22
 * 01背包
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,10,6}));
    }
    public static boolean canPartition(int[] nums) {
        int num = Arrays.stream(nums).sum();
        if (num % 2 == 1) return false;
        int target= num / 2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for (int i = 0;i<=nums.length;i++) {
            dp[i][0] = true;//注意初始化的问题，别漏了。
        }
        //01背包二维数组的模板
        for (int i = 1 ;i <= nums.length;i++) {
            for (int j = 0  ;j<=target;j++) {
                if (j<nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }

            }
        }
        return dp[nums.length][target];
    }
}
