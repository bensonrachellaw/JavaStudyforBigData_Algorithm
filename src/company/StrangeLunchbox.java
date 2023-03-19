package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/23
 */
public class StrangeLunchbox {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int X = reader.nextInt();
        int Y = reader.nextInt();

        int[] a = new int[N+1];
        int[] b = new int[N+1];

        for (int i = 1 ; i <= N;i++){
            a[i] = reader.nextInt();
            b[i] = reader.nextInt();
        }

        int[][] dp = new int[X+1][Y+1];
        for (int i = 0;i<=X;i++){
            for (int j = 0;j<=Y;j++) {
                dp[i][j] = 301;
            }
        }
        dp[0][0] = 0;
        for (int i = 1 ; i <= N;i++){
            for (int x = X;x>=0;x--){
                for (int y = Y;y>=0;y--) {
                    dp[x][y] = Math.min(dp[x][y],dp[Math.max(x-a[i],0)][Math.max(y-b[i],0)]+1);
                }
            }
        }

        if(dp[X][Y]==301){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[X][Y]);
        }
    }
}
