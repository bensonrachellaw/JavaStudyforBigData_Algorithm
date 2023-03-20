package ZJCampus;

import java.util.Random;

public class DayFive2 {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quicksort(nums,0,nums.length-1,nums.length-k);
        // #如果问第k小就直接使用k-1
        // 第k大就是升序排序后，第nums.length-k个位置的数
    }

    public static int quicksort(int[] nums,int l ,int r,int k){
        int pivot = random.nextInt(r-l+1)+l;//左闭右开的。先在l-r范围随机选一个数。

        swap(nums,l,pivot);
        //交换这个数到数组最前面。
        int i = l;

        for (int j = i+1;j<nums.length;j++){
            if (nums[j]<nums[l]) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums,i,l); //这里将当次的pivot的数放到它正确的位置上。

        if (i==k){
            return nums[i];
        }
        else if (i>k){
            return quicksort(nums,l,i-1,k);
        }
        else {
            return quicksort(nums,i+1,r,k);
        }

    }

    public static void swap(int[] nums,int i ,int j){
        //一定要把数组放进交换函数里。
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
