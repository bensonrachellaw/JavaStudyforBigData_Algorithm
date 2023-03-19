package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/24
 * 用了int modulo = 1000000007;就会超时
 */
public class CoinCombinationsI {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int x = reader.nextInt();

        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }

        int[] dp = new int[x+1];
        dp[0] = 1;

        for (int i = 1;i<=x;i++){
            for (int j = 0;j<=n-1;j++){
                if (i >= a[j]) {
                    dp[i] = (dp[i] + dp[i - a[j]]) % 1000000007;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
