package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/7
 * 子序列是可以不连续的，子串是一定要连续的
 * LC1143《最长公共子序列》
 */
public class LCS {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        String t = reader.next();

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int len_ans = dp[m][n];
        char[] ans = new char[len_ans];
        int i = m;
        int j = n;

        while(len_ans>0){
            if(s.charAt(j-1) == t.charAt(i-1)) {
                ans[len_ans-1] = s.charAt(j-1);
                i--;
                j--;
                len_ans--;
            }
            else if (dp[i][j]==dp[i][j-1]){
                j--;
            }
            else {
                i--;
            }
        }
        System.out.println(new String(ans));

    }
}
