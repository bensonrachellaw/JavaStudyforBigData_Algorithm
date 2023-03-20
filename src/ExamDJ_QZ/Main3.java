package ExamDJ_QZ;

import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] s = reader.nextLine().split(" ");
        int[] num = new int[s.length];
        for (int i = 0;i<s.length;i++){
            num[i] = Integer.parseInt(s[i]);
        }

        int[] dp = new int[s.length+1];
        dp[1] = num[0];
        for (int i = 2;i<=s.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+num[i-1]);
        }
        System.out.println(dp[s.length]);
    }
}
