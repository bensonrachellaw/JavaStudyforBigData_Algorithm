package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/9
 */
public class FGoperation {
    public static void main(String[] args) {
        int modulo = 998244353;
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        int[] a = new int[N+1];
        for (int i = 1;i<=N;i++){
            a[i] = reader.nextInt();
        }

        int[][] dp = new int[N+1][10];

        dp[1][a[1]] = 1;

        for (int i = 2;i<=N;i++){
            for (int j = 0;j<=9;j++){
                int f = (j+a[i])%10;
                int g = (j*a[i])%10;

                dp[i][f] = (dp[i][f] + dp[i-1][j])%modulo;
                dp[i][g] = (dp[i][g] + dp[i-1][j])%modulo;
            }
        }

        for (int i = 0;i<=9;i++){
            System.out.println(dp[N][i]);
        }
    }
}
