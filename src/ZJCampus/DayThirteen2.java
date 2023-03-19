package ZJCampus;

public class DayThirteen2 {
    public static void main(String[] args) {

    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length - 1 - 1;
        int l = -1;
        while (n>=0){//从后向前查找第一个相邻升序的元素对
            if (nums[n]<nums[n+1]){
                l = n;
                break;
            }
            n--;
        }
        if (l==-1) {
            reverse(nums,0,nums.length - 1);
            return;
        }
        int r = -1;
        int m = nums.length - 1;
        while (m>l){//找出比它稍微大的数的位置
            if (nums[m]>nums[l+1]){
                r = m;
                break;
            }
            m--;
        }
        swap(nums,l,r);
        reverse(nums,l+1,nums.length-1);
        return;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);//把升序转为逆序。或者把逆序转为升序。
        }
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
