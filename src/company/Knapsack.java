package com.company;
//提交时不能有package，且主函数必须为Main！
import java.io.*;
import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/13
 * 01背包
 */
public class Knapsack {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int W = reader.nextInt();

        long[] dp = new long[W+1];
        for (int i = 1;i<= N;i++) {
            int w = reader.nextInt();
            int v = reader.nextInt();
            for (int j = W ;j >= w;j--) {
                dp[j] = Math.max(dp[j],dp[j-w]+v);
            }
        }
        System.out.println(dp[W]);
    }
}


