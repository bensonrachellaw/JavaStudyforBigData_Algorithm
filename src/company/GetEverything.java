package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/11/7
 */
public class GetEverything {
    public static void main(String[] args) {
        int max_Int = (int) 1e9;

        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int m = reader.nextInt();

        int[] dp = new int[1<<n];
        Arrays.fill(dp, max_Int);

        dp[0] = 0;
        for (int i = 0;i<m;i++){
            int a = reader.nextInt();
            int b = reader.nextInt();
            int mask = 0;
            for (int k = 0;k<b;k++){
                int c = reader.nextInt();
                mask |= (1<<(c-1));
            }

            for (int j = 0;j<(1<<n);j++){
                dp[j|mask] = Math.min(dp[j|mask],dp[j]+a);
            }
        }

        if (dp[(1<<n)-1]==max_Int){
            dp[(1<<n)-1] = -1;
        }

        System.out.println(dp[(1<<n)-1]);
    }
}
