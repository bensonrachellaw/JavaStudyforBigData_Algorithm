package ExamMT_QZ3;

import java.util.*;
//编辑距离!!改版。
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        for (int i = 0;i<m;i++) {
            b[i] = reader.nextInt();
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i<=n;i++) {
            dp[i][0] = dp[i-1][0]+Math.abs(a[i-1]);
        }
        for (int i = 1;i<=m;i++) {
            dp[0][i] = dp[0][i-1]+Math.abs(b[i-1]);
        }

        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=m;j++) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+Math.abs(a[i-1]),dp[i][j-1]+Math.abs(b[j-1])),dp[i-1][j-1]+Math.abs(a[i-1]-b[j-1]));
            }
        }
        System.out.println(dp[n][m]);
    }
}