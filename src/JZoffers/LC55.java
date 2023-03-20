package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/14
 * LC55：跳跃游戏
 */
public class LC55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0;i<n;i++){
            for (int j = 1;j<=nums[i];j++){
                dp[i+j] = dp[i];
                if (dp[n - 1]) return true;
            }
        }
        return dp[n-1];
    }
    public boolean canJump1(int[] nums) {
        //对于每一个可以到达的位置 x，它使得 x+1, x+2,⋯,x+nums[x] 这些连续的位置都可以到达。

        int n = nums.length;
        int rightmost = 0;//实时维护一个最远可以到达的位置rightmost
        for (int i = 0;i<n;i++){
            if (i>rightmost) return false;//想要更新最远可以到达的前提是本身这个位置是当前的rightmost可以到达的。如果存在某个不可达的位置，那么后面的位置都不可达。
            //所以要先判断，所以要先执行if (i>rightmost) return false;
            rightmost = Math.max(rightmost,i+nums[i]);
        }
        return true;//如果一路遍历都不存在不可达的位置，那么最终位置就是可达。
    }
    public boolean canJump2(int[] nums) {
        //思路也差不多，只是判断条件反过来写了
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {//想要更新最远可以到达的前提是本身这个位置是可以到达的。
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
