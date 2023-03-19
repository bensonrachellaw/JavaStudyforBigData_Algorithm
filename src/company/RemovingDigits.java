package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/26
 */
public class RemovingDigits {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        int max_Int = 1000005;

        int[] dp = new int[1000001];

        dp[0] = 0;
        for (int i = 1;i<=9;i++){
            dp[i] = 1;
        }
        for (int i = 10;i<=1000000;i++){
            dp[i] = max_Int;
        }
        for (int i = 10;i<=n;i++){
            int tmp = max_Int;
            String s = Integer.toString(i);
            for (int j = 0;j < s.length();j++){
                tmp = Math.min(tmp,dp[i-Integer.parseInt(String.valueOf(s.charAt(j)))]+1);
            }
            dp[i] = tmp;

        }
        System.out.println(dp[n]);
    }
}
