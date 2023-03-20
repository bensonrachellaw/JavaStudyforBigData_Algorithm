package ZJCampus;

import java.util.Arrays;

public class DayTwelve1 {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n+1][m+1];
        for (int i = 0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
    //如果要输出路径，则需要从最后往前找。
}
