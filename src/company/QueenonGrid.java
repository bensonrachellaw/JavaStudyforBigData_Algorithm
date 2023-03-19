package com.company;

import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/13
 */
public class QueenonGrid {
    public static void main(String[] args) {

        int modulo = 1000000007;


        Scanner reader = new Scanner(System.in);
        int h = reader.nextInt();
        int w = reader.nextInt();

        char[][] grid = new char[h][w];
        for (int i = 0;i<h;i++){
            String s = reader.next();
            for (int j = 0;j<w;j++){
                grid[i][j] = s.charAt(j);
            }
        }

        long[][] dp = new long[h][w];
        long[][] rr = new long[h][w];
        long[][] dd = new long[h][w];
        long[][] rd = new long[h][w];
        dp[0][0] = 1;
        rr[0][0] = 1;
        dd[0][0] = 1;
        rd[0][0] = 1;


        for (int i = 1;i<w;i++){
            if (grid[0][i] == '.'){
                dp[0][i] = rr[0][i-1]%modulo;
                rr[0][i] = (rr[0][i-1] + dp[0][i])%modulo;
                dd[0][i] = dp[0][i]%modulo;
                rd[0][i] = dp[0][i]%modulo;
            }
        }

        for (int i = 1;i<h;i++){
            if (grid[i][0] == '.'){
                dp[i][0] = dd[i-1][0]%modulo;
                rr[i][0] = dp[i][0]%modulo;
                dd[i][0] = (dd[i-1][0] + dp[i][0])%modulo;
                rd[i][0] = dp[i][0]%modulo;
            }

        }

        for (int i = 1;i<h;i++) {
            for (int j = 1; j <w; j++) {
                if (grid[i][j] == '.'){
                    dp[i][j] = (rr[i][j-1] + dd[i-1][j] + rd[i-1][j-1])%modulo;
                    rr[i][j] = (rr[i][j-1] + dp[i][j])%modulo;
                    dd[i][j] = (dd[i-1][j] + dp[i][j])%modulo;
                    rd[i][j] = (rd[i-1][j-1] + dp[i][j])%modulo;
                }
            }
        }

        System.out.println(dp[h-1][w-1]%modulo);
    }
}
