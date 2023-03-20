package JZoffers;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/7
 */
public class Completeknapsackproblem {
    //一维数组，二层循环做法。
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int v = reader.nextInt();//背包容积
        int[] dp = new int[v+1];
        for (int i = 0;i<n;i++){
            int w = reader.nextInt();//体积；
            int cost = reader.nextInt();//价值
            for (int j = w;j<=v;j++){//完全背包的一维数组解法的内层循环是顺序的（01背包是逆序）
                dp[j] = Math.max(dp[j],dp[j-w]+cost);
            }
        }
        System.out.println(dp[v]);
    }
}
