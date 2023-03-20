package com.company;

import java.util.Scanner;

public class Main {
    /**
     *
     * @param args
     *
     */
    public static void main(String[] args) {
	// write your code here
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。
        for (int i = 0;i<n;i++){
            String s = reader.nextLine();
            String[] w = s.split(" ");
            System.out.println(w[2]);
        }
    }
}
