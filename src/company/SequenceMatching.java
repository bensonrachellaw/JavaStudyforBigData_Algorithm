package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/8
 */
public class SequenceMatching {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int m = reader.nextInt();

        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0;i<m;i++){
            b[i] = reader.nextInt();
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 1;i<=n;i++){
            dp[i][0] = i;
        }
        for (int j = 1;j<=m;j++){
            dp[0][j] = j;
        }

        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                if (a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}
