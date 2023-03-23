package Algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description: JavaStudyforBigData_Algorithm
 * Created by L6BD610_Luo on 2023/3/23
 * 从左往右，找到比左边最大值还小的最右下标，从右往左，找到比右边最小值还大的最左下标
 */
public class 最短无序连续子数组 {
    public static void main(String[] args) {

    }
    public int findUnsortedSubarray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int R = -1;
        int L = -1;
        //从左往右，找到比左边最大值还小的最右下标，从右往左，找到比右边最小值还大的最左下标
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]<max) {//不能加等于，因为要求的最短的，也就是最窄的
                R = i;
            }

            max = Math.max(max,nums[i]);
        }

        for (int i = nums.length - 1;i>=0;i--) {
            if (nums[i]>min) {
                L = i;
            }

            min = Math.min(min,nums[i]);
        }

        return R == -1 ? 0 : R - L + 1;//说明原本就是有序的，因此，R没变。没动过。同时这种情况L也不会动。
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] nums2 = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2);
        int l = 0,r=nums.length;
        //新加一个数组，排序，再一一比较法。注意细节。
        while (l <= r && nums[l]==nums2[l]) l++;
        while (r >= l && nums[r]==nums2[r]) r--;
        //新加一个数组，排序，两个数组再一一比较法。注意细节。
        return r-l+1;
    }
}
