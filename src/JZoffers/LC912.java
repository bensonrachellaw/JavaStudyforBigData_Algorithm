package JZoffers;

import java.util.Random;

public class LC912 {
    //数组排序。
    static Random random = new Random();

    public int[] sortArray_quick(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public int[] sortArray_merge(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        return nums;
    }


    public static void quicksort(int[] nums,int l,int r){
        if (l>=r) return;
        int pivot = random.nextInt(r-l+1)+l;//左闭右开的。先在l-r范围随机选一个数。

        swap(nums,pivot,l);//交换这个数到数组最前面。

        int i = l;
        for (int j = i+1;j<=r;j++){
            if (nums[j]<nums[l]){
                i++;
                swap(nums,j,i);
            }
        }
        swap(nums,l,i);//这里将当次的pivot的数放到它正确的位置上。

        quicksort(nums,l,i-1);
        quicksort(nums,i+1,r);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void mergeSort(int[] nums ,int left , int right , int[] tmp) {
        if (left>=right) return;
        int mid = (left+right) >> 1;

        mergeSort(nums,left,mid,tmp);
        mergeSort(nums,mid+1,right,tmp);

        int k = 0,i = left,j = mid+1;

        while (i<=mid && j<=right) {
            if (nums[i]<=nums[j]) tmp[k++] = nums[i++];//相等的话一般是取前半段的那个数，保证稳定性。
            else tmp[k++] = nums[j++];
        }
        //哪边没有循环完，就直接都接到后面。
        while (i<=mid) {
            tmp[k++] = nums[i++];
        }

        while (j<=right) {
            tmp[k++] = nums[j++];
        }
        //把排完序的数复制回原数组nums里面，因为上层递归用的是两个排好序的原数组的来进行合并。
        k=0;
        while (left<=right){
            nums[left++] = tmp[k++];
        }
    }
}
