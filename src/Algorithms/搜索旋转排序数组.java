package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/15
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
        if (nums.length==1) return nums[0]==target ? 0 : -1;//返回下标。

        int l = -1,r = nums.length;
        while (l+1<r) {
            int mid = (l+r) >> 1;
            if (nums[mid]==target) return mid;
            //下面开始分两种情况：分别判断是mid的左边完全有序还是mid的右边完全有序。
            if (nums[mid]>=nums[l+1]) {//说明左边完全有序，等号放在这里！！
                if (nums[l+1]<=target && target<nums[mid]){//判断目标值target是否在左边，也就是有序这边。
                    r = mid;//是
                }
                else {
                    l = mid;//不是的话，就得缩小范围从无序的那边继续找
                }
            }
            else if (nums[mid]<nums[l+1]) {//说明右边完全有序
                if (nums[r-1]>=target && target>nums[mid]){//判断目标值target是否在右边，也就是有序这边。
                    l = mid;//是
                }
                else {
                    r = mid;//不是的话，就得缩小范围从无序的那边继续找
                }
            }
        }
        return -1;
    }
}
//为什么感觉操作都是l=mid，r=mid，但是不能直接二分呢？
//因为你这样就不能判断走左边还是右边，只有判断出哪边有序，才能有条件判断target在不在有序的那边，因为有序可以用范围包含来判断。重点在于先判断哪半段是有序的，然后判断目标是否在有序的那半里面。


//用最左边（l+1）的值来判断左边有序时,等号就在这里，用最右边（r-1）的值来判断右边有序时,等号就在这里。注意这里，用哪边判断该边有序=就放哪边