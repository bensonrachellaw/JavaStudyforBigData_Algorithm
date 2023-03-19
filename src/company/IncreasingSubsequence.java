package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/30
 */
public class IncreasingSubsequence {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i < n;i++){
            a[i] = reader.nextInt();
        }
        int[] dp = new int[n+1];

        dp[0] = a[0];
        int cnt = 1;

        for (int i = 1;i<n;i++){
            if (a[i] > dp[cnt-1]){
                dp[cnt] = a[i];
                cnt++;
            }
            else {
                int l = -1;
                int r = cnt;
                while (l+1 < r){
                    int mid = l + (r-l)/2;
                    if (dp[mid] >= a[i]){
                        r = mid;
                    }
                    else l = mid;

                }
                dp[r] = a[i];
            }
        }
        System.out.println(cnt);
    }
}
