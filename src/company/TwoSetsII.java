package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/17
 */
public class TwoSetsII {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
        long modulo = 1000000007;
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int total = (n+1)*n/2;
        if (total%2 == 1){
            System.out.println(0);
        }
        else {
            int part = total/2;
            long[] dp = new long[part+1];
            dp[0] = 1;
            for (int i = 1;i<= n-1;i++) {
                for (int j = part ;j >= i;j--) {
                    dp[j] = (dp[j]+dp[j-i])%modulo;
                }
            }

            System.out.println(dp[part]%modulo);
//            long endTime=System.currentTimeMillis();
//            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }

    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long[] readArrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        int[] readArrayInt(int n) {
            int[] a = new int[n];
            for (int i = 1; i <= n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
