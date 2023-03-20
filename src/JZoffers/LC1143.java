package JZoffers;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/28
 */
public class LC1143 {
    public static void main(String[] args) {

    }
    //子序列是可以不连续的，子串是一定要连续的
// dp[i][j]表示s中前j个和t中前i个的LCS的长度。
// 状态转移：如果当前s[j]和t[i]相同，则可以加入到子序列中，所以dp[i][j]=dp[i-1][j-1]+1
//         如果当前s[j]和t[i]不相同，则看要当前的s[j]不要当前的t[i]，和要当前的t[i]不要当前的s[j] 两者哪个大。
//         dp[i][j] = max(dp[i-1][j],dp[i][j-1])。
//         s[j]和t[i]两个都不选这种情况已经包含在里面了。
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(text2.charAt(j-1) == text1.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);//如果当前s[j]和t[i]不相同，则看要当前的s[j]不要当前的t[i]，和要当前的t[i]不要当前的s[j] 两者哪个大。
                }
            }
        }
        return dp[m][n];
    }
}
