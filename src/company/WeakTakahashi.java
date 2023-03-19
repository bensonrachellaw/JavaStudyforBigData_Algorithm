package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/12/20
 */
public class WeakTakahashi {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int h = reader.nextInt();
        int w = reader.nextInt();

        char[][] grid = new char[h][w];
        //如何输入字符矩阵
        for (int i = 0;i<h;i++){
            String s = reader.next();
            for (int j = 0;j<w;j++){
                grid[i][j] = s.charAt(j);
            }
        }

        int[][] dp = new int[h][w];

        dp[0][0] = 1;

        for (int i = 1;i<w;i++){
            if (grid[0][i] == '.'){
                dp[0][i] = dp[0][i-1] + 1;
            }
            else {
                dp[0][i] = -101;
            }
        }
        for (int i = 1;i<h;i++){
            if (grid[i][0] == '.'){
                dp[i][0] = dp[i-1][0] + 1;
            }
            else {
                dp[i][0] = -101;
            }
        }

        for (int i = 1;i<h;i++){
            for (int j = 1;j<w;j++){
                if (grid[i][j] == '.'){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])+1;
                }
                else {
                    dp[i][j] = -(h*w + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0;i<h;i++){
            for (int j = 0;j<w;j++){
                ans = Math.max(ans,dp[i][j]);
            }
        }

        System.out.println(ans);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
