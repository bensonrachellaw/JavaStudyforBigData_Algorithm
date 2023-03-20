package ZJCampus;

import java.util.Random;
import java.util.Scanner;

public class DayNine3 {
    static Random random = new Random();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] arr = s.substring(1,s.length()-1).split(",");
        quicksort(arr,0,arr.length-1);
        StringBuilder ans = new StringBuilder("");
        for (String x : arr){
            ans.append(x);
        }
        System.out.println(ans.toString());
    }
    public static void quicksort(String[] nums,int l,int r){
        if (l>r){
            return;
        }
        int pivot = random.nextInt(r-l+1) + l;
        swap(nums,l,pivot);

        int i = l;

        for(int j = l+1;j<=r;j++){
            if (((nums[j]+nums[l]).compareTo(nums[l]+nums[j])) > 0){//如果是找最大数的话就>0
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i,l);
        quicksort(nums,l,i-1);
        quicksort(nums,i+1,r);

    }

    public static void swap(String[] nums,int i,int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
