package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/10
 */
public class Traveler {
    public static void main(String[] args) {
        int max_Int = Integer.MAX_VALUE;
        int min_Int = -max_Int;

        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        int[] leftmost = new int[N+1];
        int[] rightmost = new int[N+1];

        Arrays.fill(leftmost, max_Int);
        Arrays.fill(rightmost, min_Int);

        for (int i = 0;i<N;i++){
            int x = reader.nextInt();
            int c = reader.nextInt();

            leftmost[c] = Math.min(leftmost[c],x);
            rightmost[c] = Math.max(rightmost[c],x);
        }

        long[][] dp = new long[N+1][2];

        int lastl = 0;
        int lastr = 0;

        for (int i = 1;i<=N;i++){
            if (leftmost[i] == max_Int){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                continue;
            }


            int nowl = leftmost[i];
            int nowr = rightmost[i];

            dp[i][0] = Math.min(dp[i-1][0]+Math.abs(lastl-nowr)+Math.abs(nowl-nowr),dp[i-1][1]+Math.abs(lastr-nowr)+Math.abs(nowl-nowr));
            dp[i][1] = Math.min(dp[i-1][0]+Math.abs(lastl-nowl)+Math.abs(nowl-nowr),dp[i-1][1]+Math.abs(lastr-nowl)+Math.abs(nowl-nowr));


            lastl = nowl;
            lastr = nowr;

        }


        long ans = Math.min(dp[N][0]+Math.abs(lastl),dp[N][1]+Math.abs(lastr));

        System.out.println(ans);

    }
}
