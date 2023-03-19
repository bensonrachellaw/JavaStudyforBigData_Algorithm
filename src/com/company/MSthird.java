package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MSthird {
    /*
    对于异号的两个整数，C++/Java语言的原则是使商尽可能大，很多新型语言和网页计算器的原则是使商尽可能小。
    //java的机制是使商尽可能大。所以比如-123 % 10 = -3 （因为商这时是-12 ，如果余数是7，商就要为-13，比-12小，所以不会是-13。)
     */
    public static void main(String[] args) {
        int[] arr = {-3,-2,1,0,8,7,1};
        int M = 3;

        HashMap<Integer, ArrayList<Integer>> modArr = new HashMap<>();

        for (int i = 0;i<M;i++){
            modArr.put(i,new ArrayList<>());
        }

        for (int item:arr){
            int mod = item%M;//负数取模需要看正余数,因为System.out.println((-7) % 3); // 输出 -1
            if (mod<0){
                mod = mod + M;
            }
            modArr.get(mod).add(item);
        }
        int ans = 0;
        for (int item:modArr.keySet()){
            ans = Math.max(ans,modArr.get(item).size());
        }
        System.out.println(ans);
    }
}
