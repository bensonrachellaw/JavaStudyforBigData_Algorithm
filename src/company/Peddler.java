package com.company;

import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/28
 */
public class Peddler {
    public static void main(String[] args) {
        int max_Int = Integer.MAX_VALUE;
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int M = reader.nextInt();
        int[] a = new int[N];
        for (int i = 0;i<N;i++){
            a[i] = reader.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<N ; i++){
            adj.add(new ArrayList<>());
        }
        int[] in_cnt = new int[N];
        for (int i  = 0 ; i<M ; i++){
            int a_ = reader.nextInt();
            int b = reader.nextInt();
            adj.get(a_-1).add(b-1);
            in_cnt[b-1] += 1;
        }

        int[] dp = new int[N];
        Arrays.fill(dp, max_Int);

        int max_dp = -max_Int;
        Deque<Integer> queue=new ArrayDeque<>();

        for(int i = 0 ; i<N ; i++){
            if(in_cnt[i] == 0){
                queue.addLast(i);
            }
        }

        while (! queue.isEmpty()){
            int v = queue.pollFirst();
            max_dp = Math.max(max_dp,a[v]-dp[v]);
            for (int u : adj.get(v)){
                dp[u] = Math.min(dp[u],Math.min(dp[v],a[v]));
                in_cnt[u]--;
                if (in_cnt[u]==0){
                    queue.addLast(u);
                }
            }
        }

        System.out.println(max_dp);
    }
}
