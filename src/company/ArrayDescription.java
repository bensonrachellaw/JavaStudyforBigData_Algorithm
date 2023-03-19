package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/17
 */
public class ArrayDescription {
    public static void main(String[] args) {
        int modulo = 1000000007;
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int M = reader.nextInt();
        int[] a = new int[N];
        for (int i = 0;i<N;i++){
            a[i] = reader.nextInt();
        }


        long[][] dp = new long[N][M + 2];

        if (a[0] == 0){
            for (int i = 1;i <= M;i++ ){
                dp[0][i] = 1;
            }
        }
        else {
            dp[0][a[0]] = 1;
        }

        for (int i = 1;i<N;i++){
            if (a[i]==0){
                for (int j = 1 ;j<=M;j++){
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1])%modulo;
                }
            }
            else {
                dp[i][a[i]] = (dp[i-1][a[i]-1]+dp[i-1][a[i]]+dp[i-1][a[i]+1])%modulo;
            }
        }
        long ans = 0;
        for (int i = 1;i<=M;i++){
            ans = (ans + dp[N-1][i])%modulo;
        }


        System.out.println(ans);
    }
}
