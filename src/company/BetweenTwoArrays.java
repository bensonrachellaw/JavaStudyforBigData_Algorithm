package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/11
 */
public class BetweenTwoArrays {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0;i<n;i++){
            b[i] = reader.nextInt();
        }

        int[][] dp = new int[n][3001];
        int[] pre = new int[3001];

        for (int i = a[0];i<=b[0];i++){
            dp[0][i] = 1;
        }

        pre[a[0]] = 1;
        for (int i = a[0]+1;i<=3000;i++){
            pre[i] = pre[i-1]+dp[0][i];
        }

        for (int i = 1;i<n;i++){
            for (int j = a[i];j<=b[i];j++){
                dp[i][j] = pre[j];
            }

            pre[a[i]] = dp[i][a[i]];
            for (int k = a[i]+1;k<=3000;k++){
                pre[k] = (pre[k-1]+dp[i][k])%998244353;
            }

        }
        System.out.println(pre[3000]);

    }
}
