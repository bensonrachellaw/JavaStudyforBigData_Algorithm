package com.company;

public class peakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int l = -1;
        int r = arr.length;

        while(l+1<r){
            int mid = (l+r)/2;
            if(arr[mid]>arr[mid+1]){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        return r;//求的就是下标的最小值（符合arr[mid]>arr[mid+1]这个条件的）
    }
}
