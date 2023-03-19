package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/16
 * 区间DP 三层循环 穷举所有区间然后利用小区间里已经算好的数字来算更大的区间 从下到上填表法。
 */
public class 戳气球 {
    public static void main(String[] args) {
        //区间DP 三层循环 穷举所有区间然后利用小区间里已经算好的数字来算更大的区间 从下到上填表法。
        //DP思路是这样的，就先别管前面是怎么戳的，你只要管这个区间最后一个被戳破的是哪个气球
        //这最后一个被戳爆的气球就是k.因为k是最后一个被戳爆的，所以它周边没有球了！没有球了！只有这个开区间首尾的 i 和 j 了
        //所以针对于最后一个被戳爆的气球就是k，最终答案就是：   区间【i-k】的dp结果 + coins【i】* coins【k】* coins【j】+区间【k-j】的dp结果。
        //这两段的最优情况是互不干扰的，所以这两个部分加上最后剩下的气球得到的值，就是最优解，所以满足最关键的 每个子问题的决策不能对后面其他未解决的问题产影响，无后效性
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n+2];
        coins[0] = 1;
        coins[n+1] = 1;
        //依据题意，涉及边界时，乘的是1，所以直接在原数组左右加上1变成新的数组coins；统一操作。
        for (int i = 0 ; i < n; i++) {
            coins[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];//最终求dp[0][n+1]，i，j为开区间
        //dp[i][j]代表在（i，j）开区间内戳爆所有气球获得最大的硬币数量。因此我们最后需要求的dp[0][n+1]的值，等于把原数组所有的气球都戳爆了得到的最大硬币数。
        //dp[i][j] = dp[i][k]+coins[i]*coins[k]*coins[j]+dp[k][j],dp[i][j]依赖于已经计算好的dp[i][k]和dp[k][j]，(i < k < j)
        //从下到上 从左到右填表法：
        //请注意：脑中画图(i < k < j)是coins数组的位置比较。在dp数组中就不是这样了。
        /**
        (i,i)(i,i+1) ……   (i,j-1)(i,j)
                                 (i+1,j)

                                   ……

                                 (j-1,j)
                                 (j,j)
         */
        for (int i = n+1;i >= 0;i--) {
            for (int j = i+1;j <= n+1;j++) {//外层两个循环就是穷举所有区间范围，也就是穷举所有的i和j
                int max = 0;
                for (int k = i + 1;k < j ;k++) {//最内层循环计算当前(i，j)区间的最大硬币数，作为局部子结果
                    max = Math.max(dp[i][k]+dp[k][j]+coins[i]*coins[k]*coins[j],max);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n+1];
    }
}
