package ExamTX;

import java.util.Arrays;
import java.util.Scanner;

//腾讯暑期实习笔试第五题：

/**
 *
 * 5.小Q的最大总资产
 * 题目:
 * 现在有一个长度为n的价格数组a，表示某只股票 每天的 价格，你每天最多买入或卖出该只股票的1手股票，买入或者卖出没有手续费，且卖出股票前必须手里已经有股票才能卖出，
 * 但是持有的股票数目不受限制，并且初始资金为m元，你在任意时刻都不能进行透支，所以你的资金必须始终大于等于 0 。
 * 请问你在n天结束之后，拥有最大的总资产是多少?（总资产:股票数目*股票价格+现金)
 * 输入
 * 6 2
 * 2 3 1 1 1 2
 * 输出:
 * 6
 */

/**
 *
 * 01背包变种。定义dp[i][j]代表前i天，手上当前持有j只股票的最大现金数。那么可以根据每天选择买入还是卖出达成转移还是不操作。
 * 求最后一天的最大现金数+加上股数*最后一天的股票价格。
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1;i<=n;i++){
            arr[i] = reader.nextInt();
        }
        int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp[0],-1);
        dp[0][0] = m;

        //填表DP：注意每天是只能买一手或者卖一手，不能买卖超过一手！！

        for (int i = 1;i<=n;i++){
            for (int j = 0;j<=n;j++){
                dp[i][j] = dp[i-1][j];//不操作（啥也不干）；
                if (j>0&&dp[i-1][j-1]>=arr[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]-arr[i]);//买入一手当天的股票；现金会减少。
                }
                if (j<n){
                    if (dp[i-1][j+1]!=-1){//在前一天的基础上卖出一手股票，现金会增加。
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j+1]+arr[i]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0;i<=n;i++){
            if (dp[n][i]==-1) continue;
            ans = Math.max(ans,dp[n][i]+i*arr[n]);
        }
        System.out.println(ans);
    }
}
