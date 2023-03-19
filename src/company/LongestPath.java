package com.company;

import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/27
 */
public class LongestPath {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int M = reader.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<N ; i++){
            adj.add(new ArrayList<>());
        }
        int[] in_cnt = new int[N];
        for (int i  = 0 ; i<M ; i++){
            int a = reader.nextInt();
            int b = reader.nextInt();
            adj.get(a-1).add(b-1);
            in_cnt[b-1] += 1;
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 0);

        int max_dp = 0;
        Deque<Integer> queue=new ArrayDeque<>();//ArrayDeque不能存null类型的元素，建议使用Queue<TreeNode> que = new LinkedList<>();

        for(int i = 0 ; i<N ; i++){
            if(in_cnt[i] == 0){
                queue.addLast(i);
            }
        }

        while (! queue.isEmpty()){
            int v = queue.pollFirst();
            for (int u : adj.get(v)){
                if (dp[v] + 1 > dp[u]){
                    dp[u] = dp[v] + 1;
                    max_dp = Math.max(max_dp,dp[u]);
                }
                in_cnt[u]--;
                if (in_cnt[u]==0){
                    queue.addLast(u);
                }
            }
        }
        System.out.println(max_dp);
    }
}
