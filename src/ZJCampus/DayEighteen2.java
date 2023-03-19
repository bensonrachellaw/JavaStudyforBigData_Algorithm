package ZJCampus;

public class DayEighteen2 {
    public int rob(int[] nums) {
        //dp[i] 代表 偷窃 前i个（包括i）房屋的最大金额
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for (int i = 2;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}
