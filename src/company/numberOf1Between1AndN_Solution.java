package com.company;

import java.util.ArrayList;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/11/4
 */
class numberOf1Between1AndN_Solution {
    public int numberOf1Between1AndNSolution(int n) {
        if(n==0){
            return 0;
        }
        ArrayList<Integer> adj = new ArrayList<>();
        while (n>0){
            adj.add(n%10);
            n = n / 10;
        }

        int res = 0;
        for (int i = adj.size()-1;i>=0;i--){
            int l = 0 , r = 0;
            int t = 1;
            for (int j = adj.size()-1;j>i;j--){
                l = l * 10 + adj.get(j);

            }
            for (int j = i-1;j>=0;j--){
                r = r * 10 + adj.get(j);
                t *= 10;
            }

            res += l * t;
            if(adj.get(i)==1){
                res += r + 1;
            }
            else if (adj.get(i)>1){
                res += t;
            }

        }

        return res;
    }
}