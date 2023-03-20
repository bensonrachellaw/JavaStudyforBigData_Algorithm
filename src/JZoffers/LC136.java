package JZoffers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/19
 */
public class LC136 {
    public static void main(String[] args) {

    }

    /**
     *
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     * a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     */
    //不需要额外空间的方法，就往位运算上想
    public int singleNumber(int[] nums) {
        int start = 0;
        for (int item : nums){
            start = start ^ item;
        }
        return start;
    }
    public int singleNumber2(int[] nums) {
        return Arrays.stream(nums).reduce((a, b)->a^b).getAsInt();
    }
    //每个不同的数的总和乘以2 再减去nums的总和。需要额外空间。很妙但是需要额外的空间。
    public int singleNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums){
            sum1 += i;
            if (!set.contains(i)){
                set.add(i);
                sum2 += i;
            }
        }
        return 2*sum2 - sum1;
    }
    //0 1 2 3 4 5 6 7 8
    //变成有序数组后，需要O(logN)复杂度。 思路：二分查找。分找到mid后，mid的左右是奇数个还是偶数个。
    public int singleNumber4(int[] nums) {
       Arrays.sort(nums);
       int l = -1;
       int r = nums.length;
       int ans = 0;
       while (l+1<r){
           int mid = (l+r)>>1;
           if (mid==0 || mid==nums.length-1) return nums[mid];
           if (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) {
               ans = nums[mid];
               break;
           }
           if (mid%2==0){//奇数个
               if (nums[mid] == nums[mid+1]){
                   l = mid;
               }
               else {
                   r = mid;
               }
           }
           else {//偶数个
               if (nums[mid] == nums[mid+1]){
                   r = mid;
               }
               else {
                   l = mid;
               }
           }

       }
       return ans;
    }
}
