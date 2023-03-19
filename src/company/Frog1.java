package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/23
 */
public class Frog1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n+1];

        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }

        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = Math.abs(a[2]-a[1]);

        for (int i = 3;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+Math.abs(a[i]-a[i-1]),dp[i-2]+Math.abs(a[i]-a[i-2]));
        }
        System.out.println(dp[n]);

    }
}
