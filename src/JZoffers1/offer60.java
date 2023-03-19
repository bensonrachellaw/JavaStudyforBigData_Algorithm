package JZoffers1;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/12/16
 * 最大礼物价值
 */
public class offer60 {
    public static void main(String[] args) {

    }
    static int maxValue(int[][] grid) {
        int n = grid[0].length;

        int[] dp = new int[n+1];

        for (int[] ints : grid) {//遍历grid每一行
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j - 1] + ints[j - 1], dp[j] + ints[j - 1]);
            }
        }
        return dp[n];
    }
}
