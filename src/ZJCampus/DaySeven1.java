package ZJCampus;

public class DaySeven1 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(max,sum);
            sum = Math.max(sum,0);//如果一段加起来小于0就可以抛弃不要了。
        }
        return max;
    }
    public int maxSubArray1(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
