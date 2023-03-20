package com.company;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 给定数组、和一个整数x，数组里表示每个题的难度系数，题目必须按着数组的顺序做下去，
 * 并且规定难度系数相差不超过x的可以放在同一天进行完成，
 * 问最少需要多少天把题目全部做完。
 */
public class MSfirst {
    public static void main(String[] args) {
        int[] arr = {5,8,2,11,12};
        int X = 1;
        Arrays.fill(arr,-1);
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int ans = 0;
        while (i < arr.length){
            set.add(arr[i]);
            if (Collections.max(set) - Collections.min(set) > X){
                set.clear();
                i--;
                ans++;
            }
            i++;
        }
        ans++;
        System.out.println(ans);
    }

}
