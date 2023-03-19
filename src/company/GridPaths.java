package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/25
 */
public class GridPaths {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        char[][] grid = new char[n][n];
        //如何输入字符矩阵
        for (int i = 0;i<n;i++){
            String s = reader.next();
            for (int j = 0;j<n;j++){
                grid[i][j] = s.charAt(j);
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = 1;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                if (grid[i-1][j-1] != '*'){
                    dp[i][j] = (dp[i][j]+dp[i-1][j]+dp[i][j-1])%(1000000007);
                }
                else dp[i][j] = 0;
            }
        }

        System.out.println(dp[n][n]);
    }
}
