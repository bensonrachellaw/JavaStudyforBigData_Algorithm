package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/10/21
 */
public class LISonTree {
    public static void main(String[] args) {
        FastScanner reader = new FastScanner();//用快读才可以过。
        int max_Int = Integer.MAX_VALUE;

        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }//别忘了初始化adj还有这个操作。
        for (int i  = 0 ; i<n-1 ; i++){
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }

        int[] ans = new int[n];

        int[] dp = new int[n];
        Arrays.fill(dp, max_Int);
        int[] res = dfs(0,-1,dp,adj,ans,a,1);
        for (int i = 0;i<n;i++){
            System.out.println(res[i]);
        }


    }

    public static int[] dfs(int now,int parent,int[] dp,ArrayList<ArrayList<Integer>> tree,int[] ans,int[] a,int cnt){
        //java递归没有那么方便，很多参数都要传进来，而且没有bisect库
        int num = a[now];
        int raw;
        int insert_index;
        if (num > dp[cnt-1]){//插在最后面的情况，数组长度cnt++
            dp[cnt] = num;
            insert_index = cnt;
            cnt++;
            raw = Integer.MAX_VALUE;
        }
        else {//这种情况，也就是在中间的情况，dp数组长度没变
            int l = -1;
            int r = cnt;
            while (l+1 < r){
                int mid = l + (r-l)/2;
                if (dp[mid] >= num){
                    r = mid;
                }
                else l = mid;

            }
            raw = dp[r];
            dp[r] = num;
            insert_index = r;
        }

        ans[now] = cnt;//赋值当前now的dp数组长度就是当前now为终点的路径的LIS长度。
        for (int u : tree.get(now)){//进入递归
            if (u==parent){
                continue;
            }
            ans = dfs(u,now,dp,tree,ans,a,cnt);
        }

        dp[insert_index] = raw;//回溯
        if (num > dp[cnt-1]){//回溯cnt，如果前面加了，这里就要减回来
            cnt = cnt - 1;
        }

        return ans;//返回这轮结束的ans供下一轮递归使用
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
