package com.company;
//提交时不能有package，且主函数必须为Main！
import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/15
 */
public class CoinCombinationsII {
    public static void main(String[] args) {

        int modulo = 1000000007;
        FastScanner reader = new FastScanner();

        int n = reader.nextInt();
        int x = reader.nextInt();

        int[] a = new int[n+1];
        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }

        int[] dp = new int[x+1];
        dp[0] = 1;

        for(int i = 1;i<=n;i++){
            for (int j = a[i];j<=x;j++){
                dp[j] = (dp[j] + dp[j-a[i]])%modulo;
            }
        }

        System.out.println(dp[x]%modulo);


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
