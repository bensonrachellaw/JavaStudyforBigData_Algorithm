package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/24
 */
public class Frog2 {
    public static void main(String[] args) {
        int max_Int = Integer.MAX_VALUE;

        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] a = new int[n+1];
        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = Math.abs(a[2]-a[1]);
        for (int i = 3;i<=n;i++){
            int total = max_Int;
            int temp = Math.min(k,i-1);
            for (int j = 1;j<=temp;j++){
                int x = dp[i-j]+Math.abs(a[i]-a[i-j]);
                if (x<total){
                    total = x;
                }
            }
            dp[i] = total;
        }
        System.out.println(dp[n]);
    }
}
