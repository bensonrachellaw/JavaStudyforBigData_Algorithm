package JZoffers;

import java.util.*;
//https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/（找最小数）
//https://leetcode-cn.com/problems/largest-number/（找最大数）
public class JianZhi45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,30,34,5,9};
        String s = solution.minNumber(arr);
        System.out.println(s);
    }
    public static class Solution {//内部类可以使用static修饰!但是只能也是默认访问权限为public（默认，不用写也行）
        /*
        这题有特殊的排序判断规则 为：

        若拼接字符串 x + y > y + x，则 x “大于” y ；
        反之，若 x + y < y + x ，则 x “小于” y ；
        x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
        */
        static Random random = new Random();
        public String minNumber(int[] nums) {

            StringBuilder s = new StringBuilder("");
            String[] strs = new String[nums.length];
            for (int i = 0;i<nums.length;i++){
                strs[i] = String.valueOf(nums[i]);
            }
            quicksort(strs,0,nums.length - 1);
            for (int i = 0;i<nums.length;i++){
                s.append(String.valueOf(strs[i]));
            }

            return s.toString();
        }

        public static void quicksort(String[] nums,int l,int r){
            if (l>r){
                return;
            }
            int pivot = random.nextInt(r-l+1) + l;
            swap(nums,l,pivot);

            int i = l;

            for(int j = l+1;j<=r;j++){
                if (((nums[j]+nums[l]).compareTo(nums[l]+nums[j])) < 0){//如果是找最大数的话就>0
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
}
