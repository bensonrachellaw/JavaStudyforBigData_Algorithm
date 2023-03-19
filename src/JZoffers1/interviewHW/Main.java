package JZoffers1.interviewHW;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1};
        System.out.println(LC26(arr));
    }
    public static int LC26(int[] nums){
        int n = nums.length;
        if (n==0) return 0;
        int i = 0;
        for (int j = 1;j<n;j++){
            if (nums[j-1]==nums[j]){

            }
            else if (nums[j-1]<nums[j]){
                nums[i] = nums[j-1];
                i++;
            }
        }
        nums[i] = nums[n-1];
        i++;
        System.out.println(i);
        return i;
    }
}
