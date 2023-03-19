package ZJCampus;

import java.util.Random;

public class Day21_2 {
    static Random random = new Random();

    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }

    public static void quicksort(int[] nums,int l,int r){
        if (l>=r) return;
        int pivot = random.nextInt(r-l+1)+l;

        swap(nums,pivot,l);

        int i = l;
        for (int j = i+1;j<=r;j++){
            if (nums[j]<nums[l]){
                i++;
                swap(nums,j,i);
            }
        }
        swap(nums,l,i);

        quicksort(nums,l,i-1);
        quicksort(nums,i+1,r);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
