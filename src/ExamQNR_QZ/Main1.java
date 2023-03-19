package ExamQNR_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/7
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println();
    }
    public int maxScore (int energy, int[][] actions) {
        // write code here
        int[] dp = new int[energy+1];
        int N = actions.length;
        for (int i = 1;i<= N;i++) {
            int w = actions[i-1][0];
            int v = actions[i-1][1];
            for (int j = energy ;j >= w;j--) {
                dp[j] = Math.max(dp[j],dp[j-w]+v);
            }
        }
        return dp[energy];
    }
}
