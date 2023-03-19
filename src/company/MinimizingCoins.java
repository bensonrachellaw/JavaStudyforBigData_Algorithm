package com.company;
import java.io.*;
import java.util.*;
/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/16
 */
public class MinimizingCoins {
    public static void main(String[] args) {
        long max = 1000001;

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int x = reader.nextInt();

        int[] a = new int[n+1];
        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }

        long[] dp = new long[x+1];
        for (int i = 1;i<=x;i++){
            dp[i] = max;
        }


        for(int i = 1;i<=n;i++){
            for (int j = a[i];j<=x;j++){
                dp[j] = Math.min(dp[j],dp[j-a[i]]+1);
            }
        }
        if (dp[x]==max){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[x]);
        }

    }
}
