package ZJCampus;

import java.util.HashMap;

public class DaySeven3 {
    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            if (nums[i]>0){
                map.put(nums[i],i);
            }
        }
        int ans = 0;
        for (int i = 1 ;i<=Integer.MAX_VALUE;i++){
            if (map.get(i)==null){
                ans = i;
                break;
            }
        }
        return ans;
    }
    /*
    时间复杂度为O（n），空间复杂度为O（1）的做法。置换法，直接把原数组当成一个map。
     */
    public static int firstMissingPositive1(int[] nums) {
        //对应位置应该为 1在0，2在1，这样。防止出现nums为[1]，[1,2]的情况。这样会导致数组最后一个数被吞掉然后输出数组长度。
        int n = nums.length;
        for (int i = 0;i<n;i++){
            while (nums[i]>0 && nums[i]<= n && nums[nums[i]-1]!= nums[i]){
                // 并不是一直换到该位置相等！，是一直换到 新换来的数 在其应该要在的位置就行。
                // 比如在下标2的位置存着6，那只要判断6是否在下标5的位置即可，不需要判断此下标1存着是不是2，不然会死循环（因为有可能存在两个6）
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i=0;i<n;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
