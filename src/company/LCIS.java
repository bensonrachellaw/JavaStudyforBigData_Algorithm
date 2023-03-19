package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/19
 */
public class LCIS {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }

        int m = reader.nextInt();
        int[] b = new int[m];
        for (int i = 0;i<m;i++){
            b[i] = reader.nextInt();
        }

        int[][] dp = new int[n+1][m+1];

        int[] pre_k = new int[m+1];

        Arrays.fill(pre_k, -1);

        for (int i = 1;i<=n;i++){
            int max_k = 0;
            int k = -1;
            for (int j = 1;j<=m;j++){
                if (a[i-1] != b[j-1]){
                    dp[i][j] = dp[i-1][j];
                    if (a[i-1]>b[j-1] && max_k < dp[i-1][j]){
                        max_k = dp[i-1][j];
                        k = j;
                    }
                }
                else {
                    dp[i][j] = max_k + 1;
                    pre_k[j] = k;
                }
            }
        }

        int ans = 0;
        int w = 0;

        for (int i  = 1;i<=m;i++){
            if( ans < dp[n][i]){
                ans = dp[n][i];
                w = i;
            }
        }
        System.out.println(ans);
        if (ans!=0){
            output(w,pre_k,b);
        }



    }

    public static void output(int w, int[] pre_k,int[] b){
        if (w != -1){
            output(pre_k[w],pre_k,b);
            System.out.print(b[w-1]+" ");
        }
    }
}
