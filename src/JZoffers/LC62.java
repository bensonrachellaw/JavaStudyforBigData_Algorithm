package JZoffers;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/15
 * LC62：不同路径（dp or 组合数学）
 */
public class LC62 {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        //简单数路径个数的DP问题
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                if (dp[i][j]!=0) continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public int uniquePaths_(int m, int n) {
        //dp空间优化：一维数组（滚动数组）：一行一行往下滚动，不是一列一列往右滚动。
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[j] = dp[j] + dp[j-1];//dp[j]是代表dp[i-1][j]（从上方过来），dp[j-1]代表dp[i][j-1]（从左方过来）
            }
        }
        return dp[n-1];
    }
    public int uniquePaths1(int m, int n) {
        //算一个组合数：机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走不就行了吗？即C（（m+n-2），（m-1））
        //组合数学法:任何数都可整除1,连续的2个数中一定有一个是2的倍数,连续的3个数中一定有一个是3的倍数
        //像下面这样做才能防止溢出
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
    /**
     * 会溢出的方法，分开算，先算分母再算分子，再相除。
     * long ans1 = 1;
     * long ans2 = 1;
     * for (int i = 1;i<m;i++){
     *      ans1 = ans1 * i;
     * }
     * for (int i = n;i<m+n-1;i++){
     *      ans2 = ans2 * i;
     * }
     * return (int)(ans2/ans1);
     */
}
