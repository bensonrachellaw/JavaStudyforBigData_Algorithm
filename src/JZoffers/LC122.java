package JZoffers;

public class LC122 {
    public static void main(String[] args) {

    }
    //122. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        //贪心最好理解
        //贪心最好理解，贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
        //（针对这道问题的特殊解法）由于不限制交易次数，只要今天股价比昨天高，就交易。
        int max = 0;
        for (int i = 1;i<prices.length;i++){
            if (prices[i]-prices[i-1]>0){
                max += prices[i]-prices[i-1];
            }
        }
        return max;
    }
    public int maxProfit_dp(int[] prices) {
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];//第一天就买了
        for (int i = 1;i<prices.length;i++){
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]+prices[i]);
            dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1]-prices[i]);
        }
        return dp[0][prices.length-1];
    }

    /**
     * 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     *
     * 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
     * 考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，
     * 或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：看具体代码
     *
     * 再来考虑 dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，或者前一天结束时还没有股票，即 dp[i−1][0]，
     * 这时候我们要将其买入，并减少 prices[i] 的收益。可以列出如下的转移方程：看具体代码。
     *
     * 对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候 dp[0][0]=0，dp[0][1]=−prices[0]。
     *
     * 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益.
     * 这里解释一下为什么最后一天不持有股票会大于持有，因为不持有代表卖出了（或者不再买了），持有代表还要花钱买（或者还未卖出）。
     */
}
