package JZoffers;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/16
 * LC：跳跃游戏 II
 */
public class LC45 {
    public static void main(String[] args) {

    }
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0;i<n;i++){
            for (int j = 1;j<=nums[i];j++){
                if(i+j>=n) continue;
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[n-1];
    }
    public int jump1_1(int[] nums) {
        //优化时间的dp方法
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int x = 0;//记录一个前一个格子的位置可以跳跃的最大长度（也就是nums数组的值）
        for (int i = 0;i<n;i++){
            for (int j = x+1;j<=i+nums[i];j++){//更新的话就从x后面的数开始更新即可。节约时间
                //原因是：每个格子其实是第一次更新时是最小的步数了，后面再到达所使用的步数只会越大，所以前面更新过的后面可以不用更新了。
                if(j>=n) continue;
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
            x = i+nums[i];
        }
        return dp[n-1];
    }
    public int jump1_2(int[] nums) {
        //优化再优化时间的dp方法
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int x = 0;//记录一个可以跳跃的最大长度maxPosition
        for (int i = 0;i<n;i++){
            for (int j = x+1;j<=i+nums[i];j++){//更新的话就从x后面的数开始更新即可。节约时间
                //原因是：每个格子其实是第一次更新时是最小的步数了，后面再到达所使用的步数只会越大，所以前面更新过的后面可以不用更新了。
                if(j>=n) continue;
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
            x = Math.max(i+nums[i],x);
        }
        return dp[n-1];
    }
    public int jump1_3(int[] nums) {
        //优化再优化再优化时间的dp方法
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int x = 0;//记录一个可以跳跃的最大长度maxPosition
        for (int i = 0;i<n;i++){
            for (int j = x+1;j<=i+nums[i];j++){//更新的话就从x后面的数开始更新即可。节约时间
                //原因是：每个格子其实是第一次更新时是最小的步数了，后面再到达所使用的步数只会越大，所以前面更新过的后面可以不用更新了。
                if(j>=n) continue;
                dp[j] = dp[i]+1;//不需要取两者较小值了，因为每个格子只会被更新一次，而这一次就是第一次更新，所以是最小的步数了。
            }
            x = Math.max(i+nums[i],x);
        }
        return dp[n-1];
    }
    public int jump2(int[] nums) {
        //核心思想是贪心方法：每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到maxPosition位置的点）作为下次的起跳点 ！
        //end 维护的是当前这一跳能达到的最右位置，若要超过该位置必须要进行一次跳跃，因此需将跳跃次数加1，并更新这次跳跃能到达的最右位置
        /**
         * 为什么迭代到len(nums) - 1 当我们迭代到倒数第二个数时，有两种情况
         * 1. 要么遇到了end，要跳一次，那么只要跳一次，就一定到最后一个数了，所以跳了就OK了，不用再看最后一个数了.
         * 2. 要么没遇到end，说明end >= len(nums) - 1，即本次跳跃的范围已经涵盖num了，当前的跳跃次数已经OK了，也不用再看最后一个数了。
         */
        int length = nums.length;
        int end = 0;// 上次跳跃可达范围右边界
        int maxPosition = 0;// 目前能跳到的最远位置
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {// 到达上次跳跃能到达的右边界了,要超过该位置必须要进行一次跳跃
                end = maxPosition;//目前能跳到的最远位置变成了下次起跳位置的右边界
                steps++;//因为已经走到了当前跳跃步数的右边界。所以次数要加一。表示步入下一个区域，新的一个范围。也就是说仅当前的覆盖范围走完时，才更新覆盖范围，并将步数+1，直达当前的覆盖范围可以到终点为止
            }
        }
        return steps;
    }
    public int jump3(int[] nums) {
        //贪心方法的一个比较好理解的版本。
        int length = nums.length;
        int end = 1;// 上次跳跃可达范围右边界
        int maxPosition;// 目前能跳到的最远位置
        int start = 0;
        int steps = 0;
        while (end<length){
            maxPosition = 0;
            for (int i = start;i<end;i++){
                maxPosition = Math.max(i+nums[i],maxPosition);
            }
            start = end;// 下一次起跳点范围开始的格子
            end = maxPosition + 1;// 下一次起跳点范围结束的格子
            steps++;
        }
        return steps;
    }
}
