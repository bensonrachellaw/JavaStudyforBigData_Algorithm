package ExamCMB_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/5
 * 简单dp
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        String[] ss = s.split("]");
        int m = ss.length;
        String[] t = ss[0].split(",");

        int n = t.length;

        s = s.replace("[","");
        s = s.replace("]","");
        s = s.replace("projects = ","");

        String[] d = s.split(",");
        int[][] pro = new int[m][n];
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                pro[i][j] = Integer.parseInt(d[i*n+j]);
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = pro[0][0];
        for (int i = 1;i<n;i++) {
            dp[0][i] = dp[0][i-1]+pro[0][i];
        }
        for (int i = 1;i<m;i++) {
            dp[i][0] = dp[i-1][0]+pro[i][0];
        }
        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+pro[i][j];
            }
        }
        System.out.println("ans = "+dp[m-1][n-1]);
    }
}
