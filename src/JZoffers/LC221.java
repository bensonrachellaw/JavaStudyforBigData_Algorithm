package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/26
 */
public class LC221 {
    public static void main(String[] args) {

    }
    //利用边长而不是面积。
    //当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也同时都要是某个正方形的右下角，否则以该点为右下角的正方形最大就是它自己了。
    //这是定性的判断，那具体的最大正方形边长呢？
    //我们知道，以该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，最好的情况是以它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
    //但如果以它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，这时候只能取那三个正方形中最小的正方形的边长加1了。
    public int maximalSquare(char[][] matrix) {
        /*
         类似木桶的短板理论
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形的边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         */
        int m = matrix.length;//m行
        int n = matrix[0].length;//n行

        int max = 0;//最大边长
        int[][] dp = new int[m+1][n+1];

        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                if (matrix[i-1][j-1]!='0'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    max = Math.max(max,dp[i][j]);//实时更新max
                }
            }
        }
        return max*max;
    }
}
