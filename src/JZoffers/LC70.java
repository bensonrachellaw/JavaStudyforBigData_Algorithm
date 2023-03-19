package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/25
 */
public class LC70 {
    public static void main(String[] args) {

    }
    //注意n=1的情况。
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
