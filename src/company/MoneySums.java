package com.company;

import java.math.BigInteger;//位操作使用的类型
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/9/16
 */

public class MoneySums {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        int[] a = new int[n+1];
        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }

        int cnt = 0;
        int total = 0;
        BigInteger bitset = BigInteger.ONE;


        for (int i = 1 ; i <= n;i++){
            bitset = bitset.shiftLeft(a[i]).or(bitset);//左移；
            total += a[i];
        }

        for (int i = 1 ;i<=total;i++){
            if (bitset.testBit(i)){
                cnt += 1;
            }
        }
        System.out.println(cnt);

        for (int i = 1 ;i<=total;i++){
            if (bitset.testBit(i)){
                if(i == total){
                    System.out.print(i);
                }
                else {
                    System.out.print(i + " ");
                }
            }
        }


    }
}
