package com.company;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int n = nums.length-1;
        if (n==0){
            return nums[0];
        }
        while(n>0 && nums[n]==nums[0]){
            n--;
        }
        if(nums[n]>nums[0]){
            return nums[0];
        }
        int l = -1;
        int r = n+1;
        while(l+1<r){
            int mid = (l+r)/2;
            if(nums[mid]>=nums[0]){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        return nums[r];
    }
}
