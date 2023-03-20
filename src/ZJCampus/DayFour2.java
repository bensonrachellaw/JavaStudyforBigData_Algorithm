package ZJCampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DayFour2 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));//List可以直接返回。
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        // 先排序+双指针+利用HashSet去重。
        // a+b+c=0
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//第一个数大于 0，后面的数都比它大，肯定不成立了
                return new ArrayList<List<Integer>>(result);
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//正确去重方法，跳过，避免出现重复解,只能i与i-1比较（处理过的），不能i与i+1
                //因为前面的已经处理过，不然会漏掉情况。比如 -1 -1 2；因为程序是确定a之后往a的后面找b和c。
            }
            int left = i + 1;
            int right = nums.length - 1;
            /*
            接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0
            就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。

            如果 nums[i] + nums[left] + nums[right] < 0
            说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
            */
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    /*
                    现在要增加 left，减小 right，但是不能重复，
                    比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后
                    需要排除重复的 -1 和 3
                    */
                     /*
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    */
                    //我不用上面这种去重方式，我使用HashSet的自动去重机制。
                    //因为这些重复的三元组不仅仅里面的数一样，连顺序都是一样的。
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        //先排序+双指针+去重。
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) l++;//去重,相同元素除了第一个后面的全部都跳过
                    while (l < r && nums[r - 1] == nums[r]) r--;//去重
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
