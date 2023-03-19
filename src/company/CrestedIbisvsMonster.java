package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/23
 */

/**
   StrangeLunchbox 为01背包打怪兽（+双层限制条件），一维数组要逆序
   本题为完全背包打怪兽，一维数组不用逆序。
 */
public class CrestedIbisvsMonster {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int H = reader.nextInt();
        int N = reader.nextInt();

        int[] a = new int[N+1];
        int[] b = new int[N+1];

        for (int i = 1 ; i <= N;i++){
            a[i] = reader.nextInt();
            b[i] = reader.nextInt();
        }
        int[]dp = new int[H+1];

        for (int i = 1;i<=H;i++){
            dp[i] = 100000000;
        }

        for (int i = 1 ; i <= N;i++) {
            for (int j = 1;j <= H;j++){
                dp[j] = Math.min(dp[j],dp[Math.max(j-a[i],0)]+b[i]);
            }

        }

        System.out.println(dp[H]);
    }
}
