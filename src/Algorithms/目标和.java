package Algorithms;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData_Algorithm
 * Created by L6BD610_Luo on 2023/3/21
 */
public class 目标和 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(findTargetSumWays(arr,target));
    }

    //为了避免负数带来的下标越界，把可能取值的范围整体右移了22000。
    public static int findTargetSumWays(int[] nums, int target) {
        //初始化
        int[][] dp = new int[nums.length][50000];
        dp[0][nums[0]+22000] = 1;
        dp[0][-nums[0]+22000] = 1;
        if (nums[0]==0) {//避免一开始就是0的两种情况重叠了所带来的影响。所以不能是1，因为+0、-0都是0；
            dp[0][-nums[0]+22000] = 2;
        }

        //DP转移：dp[i][j]代表使用了前i个数进行构造后得到j值的情况数量，j不一定是target的取值范围，因为在中间时j的取值有可能越出target的范围的。
        for (int i = 1;i<nums.length;i++) {
            for (int j  = 11000;j<=33000;j++) {
                int temp1 = j - 22000 + nums[i];
                int temp2 = j - 22000 - nums[i];
                dp[i][j] = dp[i-1][temp1+22000] + dp[i-1][temp2+22000];//从两方面转移过来，从前i-1得到的值加上或减去当前nums[i]得到当前j的数量的和，
                //就是现在得到的dp[i][j]的值，就是得到用前i个数得到当前j的数量
            }
        }


        return dp[nums.length-1][target+22000];//最后再找到用所有元素后得到target的情况数量
    }


    public static int findTargetSumWays2(int[] nums, int target) {
        //找到nums一个正子集（前面放+号的）和一个负子集（前面放-号的），使得总和等于target
        //01背包问题
       int num = Arrays.stream(nums).sum();
       if (num < Math.abs(target) || (num+target) % 2 == 1) {
           return 0;
       }
       int pos = (num + target) / 2;
       int[] dp = new int[pos+1];//用前i个元素选择一些组成所有正子集的情况数量。是简化优化的一维数组，其实是二维数组。
       dp[0] = 1;//因为不用任何数而组成正子集为空子集时也是一种方案。
        //选数组成正子集
       for (int i = 0 ; i < nums.length ;i++) {
           for (int j = pos ; j>=nums[i];j--) {
               dp[j] = dp[j] + dp[j-nums[i]];
           }
       }
       return dp[pos];
    }

}
