package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/29
 */
public class Vacation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int[][] dp = new int[N][3];

        for (int i = 0 ; i < N;i++){
            dp[i][0] = reader.nextInt();
            dp[i][1] = reader.nextInt();
            dp[i][2] = reader.nextInt();

        }

        for (int i = 1 ; i < N;i++){
            dp[i][0] = Math.max(dp[i][0]+dp[i-1][1],dp[i][0]+dp[i-1][2]);
            dp[i][1] = Math.max(dp[i][1]+dp[i-1][0],dp[i][1]+dp[i-1][2]);
            dp[i][2] = Math.max(dp[i][2]+dp[i-1][0],dp[i][2]+dp[i-1][1]);
        }

        int ans = Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2]));

        System.out.println(ans);
    }
}
