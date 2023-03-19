package ZJCampus;

public class DaySeven2 {
    public static void main(String[] args) {

    }
    public static int maxProduct(int[] nums){
        int length = nums.length;
        int[] maxNums = new int[length];
        int[] minNums = new int[length];
        int ans = nums[0];
        System.arraycopy(nums, 0, maxNums, 0, length);
        System.arraycopy(nums, 0, minNums, 0, length);

        for (int i = 1;i<length;i++){
            maxNums[i] = Math.max(Math.max(maxNums[i-1]*nums[i],minNums[i-1]*nums[i]),nums[i]);
            minNums[i] = Math.min(Math.min(maxNums[i-1]*nums[i],minNums[i-1]*nums[i]),nums[i]);
            ans = Math.max(ans,maxNums[i]);
        }
        return ans;
    }
    //优化空间版本；
    public static int maxProduct2(int[] nums){
        int length = nums.length;
        int maxNum = nums[0];
        int minNum = nums[0];
        int ans = nums[0];
        for (int i = 1;i<length;i++){
            int temp_max = maxNum , temp_min = minNum;
            //暂存上一轮循环的maxNum，minNum，两行代码都用到了这两个值，用完之前不能更新。
            maxNum = Math.max(Math.max(temp_max*nums[i],temp_max*nums[i]),nums[i]);
            minNum = Math.min(Math.min(temp_min*nums[i],temp_min*nums[i]),nums[i]);
            ans = Math.max(ans,maxNum);
        }
        return ans;
//        由于第 i 个状态只和第 i−1 个状态相关，根据「滚动数组」思想，我们可以只用两个变量来维护 i−1 时刻的状态。
    }
}
