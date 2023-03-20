package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/16
 */
public class 最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];//各种情况下的此时的最大利润
        //分三种情况记住即可：持有（1）、不持有（2、3）包括延续不持有和持有但是当天卖出变成不持有.
        //初始化：
        dp[0][1] = - prices[0];//第0天持有,即第0天当天买入
        dp[0][2] = 0;//第0天不持有,即第0天不操作，不买也不卖
        dp[0][3] = 0;//第0天不持有,即第0天卖出，买了又卖了。不持股且当天卖出了

        for (int i = 1;i<prices.length;i++) {
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] - prices[i]);//第i天持有,即第i天当天买入（需要i-1不卖出，所以是2情况）或者延续之前有的。
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][3]);//第i天不是因为i天卖出不持有，是本来不持有 ，即考虑延续i-1不持有的两种情况取最大值即可。
            dp[i][3] = dp[i-1][1]+prices[i];//第i天就是因为卖出不持有，那就说明i-1一定持有，然后i卖出。
        }

        return  Math.max(dp[prices.length-1][2],dp[prices.length-1][3]);
        //最后一天的最大收益有两种可能，而且一定是“不持有”状态下的两种可能，把这两种“不持有”比较一下大小，返回即可
    }
}
