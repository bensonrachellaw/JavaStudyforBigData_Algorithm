package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/15
 */
public class 搜索旋转排序数组2 {
    public static void main(String[] args) {

    }
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        if (nums.length==1) return nums[0] == target;//返回下标。

        int l = -1 , r = nums.length;
        while (l+1 < r){
            //比33题搜索旋转排序数组就差了这两行去重
            while(l+1<r&&l+2<nums.length&&nums[l+1]==nums[l+2]) l++;
            while(l+1<r&&r-2>-1&&nums[r-1]==nums[r-2]) r--;

            int mid = (l + r) >> 1;
            if (nums[mid]==target){
                return true;
            }
            if (nums[l+1] <= nums[mid]){
                if (target>=nums[l+1] && target<nums[mid]){
                    r = mid;
                }
                else {
                    l = mid;
                }
            }
            else {
                if (target>nums[mid] && target<=nums[r-1]){
                    l = mid;
                }
                else {
                    r = mid;
                }
            }
        }

        return false;
    }
}
