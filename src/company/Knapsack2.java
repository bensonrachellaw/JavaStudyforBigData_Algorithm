package com.company;
//提交时不能有package，且主函数必须为Main！
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/14
 */
public class Knapsack2 {
    public static void main(String[] args)  throws IOException {

        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int W = reader.nextInt();

        int max = Integer.MAX_VALUE;//因为数组是long型，所以最大值不能是long型的最大值，因为再加就会变成负数。
        int res = 0;
        long[] dp = new long[N*1000+5];
        Arrays.fill(dp,max);
        dp[0] = 0;

        for (int i = 1;i <= N;i++){

            int w = reader.nextInt();
            int v = reader.nextInt();

            for (int j = N*1000;j >= v;j--){
                dp[j] = Math.min(dp[j],dp[j-v]+w);
                if(dp[j] <= W && j >= res){
                    res = j;
                }
            }
        }
        System.out.println(res);
    }
}
