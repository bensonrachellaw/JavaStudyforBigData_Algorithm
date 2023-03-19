package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/11/3
 */
public class AmountofDegrees {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        int y = reader.nextInt();

        int k = reader.nextInt();
        int b = reader.nextInt();

        int N  = 32;

        int[][] c = new int[N][N];

        for (int i = 0;i<N;i++){
            for (int j = 0;j<=i;j++){
                if (j==0){
                    c[i][j] = 1;
                }
                else {
                    c[i][j] = c[i-1][j] + c[i-1][j-1];
                }
            }
        }

        int ans = dp(y,c,k,b) - dp(x-1,c,k,b);
        System.out.println(ans);


    }

    public static int dp(int n,int[][] c,int k,int b){
        ArrayList<Integer> adj = new ArrayList<>();
        while (n>0){
            adj.add(n%b);
            n = n / b;
        }
        int res = 0;
        int last = 0;


        for (int i = adj.size()-1;i>=0;i--){
            int x = adj.get(i);
            if (x>=1){
                res += c[i][k-last];
                if (x>1){
                    if (k-last-1>=0){
                        res += c[i][k-last-1];
                    }
                    break;
                }
                else {
                    last += 1;
                    if (last>k){
                        break;
                    }
                }
            }
            if (i==0 && k==last){
                res += 1;
            }
        }
        return res;
    }
}
