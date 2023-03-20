package ZJCampus;

import java.util.ArrayList;
import java.util.Arrays;

public class DayTwelve2 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        //dp[i]代表以第i个元素结尾的最大升序序列长度为多少,一定要选i作为结尾。
        //子序列的最后一个为i。所以初始化时dp[i]都是1。
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        max = Math.max(max,1);
        return max;
    }
    public static int lengthOfLIS2(int[] nums) {
        //使用变长数组的做法,使用定长数组的方法在gitee上
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1;i<nums.length;i++){
            if (nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }
            else {
                int l = -1;
                int r = list.size();

                while(l+1<r){//求大于等于nums[i]的最小位置。并进行替换
                    int mid = (l+r) >> 1;
                    if (list.get(mid)<=nums[i]){
                        l = mid;
                    }
                    else {
                        r = mid;
                    }
                }
                list.set(r,nums[i]);
            }
        }
        return list.size();
    }

}
