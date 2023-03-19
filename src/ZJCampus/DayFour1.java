package ZJCampus;

import java.util.Arrays;
import java.util.HashMap;

public class DayFour1 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target =9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
