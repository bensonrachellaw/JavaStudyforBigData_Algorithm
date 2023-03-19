package JZoffers;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/28
 * LC718. 最长重复子数组 == 最长公共子串 。子序列是可以不连续的，子串（子数组）是一定要连续的
 */
public class LC718 {
    public static void main(String[] args) {

    }
    //如果参数是两个字符串就toCharArray()转为char数组即可。本题是int数组，其实都一样。
    //dp[i][j]代表以A[i-1]与B[j-1]结尾的公共字串的长度,公共字串必须以A[i-1]，B[j-1]结束.
    //当A[i-1] == B[j-1]时，dp[i][j] = dp[i-1][j-1] + 1; 当A[i-1] != B[j-1]时，以A[i-1]和B[j-1]结尾的公共字串长度为0,dp[i][j] = 0。
    public int findLength(int[] s1, int[] s2) {
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n+1][m+1];
        int max_len = 0;
//        int max_i;//输出子串（子数组）
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=m;j++) {
                if (s1[i-1]==s2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max_len = Math.max(max_len,dp[i][j]);
//                    if (dp[i][j] > max_len) {
//                        max_len = dp[i][j];
//                        max_i = i - 1;//也可以是j-1。只是在s1或者s2中取这个子数组而已，一样的。有长度有终点的位置，就可以取出来了。
//                    }
                }
            }
        }
        return max_len;
    }
}
