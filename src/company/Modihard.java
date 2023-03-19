package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/15
 */
public class Modihard {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int modulo = 1000000007;

        long[] A = new long[n+1];
        for (int i = 1; i < n+1; i++) {
            A[i] = reader.nextLong();
        }
        long[] prefix = new long[n + 1];
        for (int i = 1; i < n+1; i++) {
            prefix[i] = prefix[i-1] + A[i];
        }
        int[][] dp = new int[n + 1][n + 1];
        int[][] pre = new int[n + 1][n + 1];

        pre[1][0] = 1;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=i;j++){
                int t = (int) (prefix[i]%j);
                dp[i][j] = pre[j][t];
            }
            for (int j = 1;j<=n;j++){
                int tt = (int) (prefix[i]%j);
                pre[j][tt] = (pre[j][tt] + dp[i][j-1])%modulo;
            }
        }
        int ans = 0;
        for (int i = 1;i<=n;i++){
            ans = (ans + dp[n][i])%modulo;
        }

        System.out.println(ans);
    }
}
