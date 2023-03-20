package ZJCampus;

public class DayFourteen1 {
    public static void main(String[] args) {

    }
    //大致思路：动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 1;i<prices.length;i++){
            int temp = prices[i] - prices[i-1];
            max = Math.max(temp,max);
            prices[i] = Math.min(prices[i],prices[i-1]);
        }
        return max >= 0 ? max : 0;
    }
}
