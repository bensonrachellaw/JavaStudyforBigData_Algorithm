package JZoffers;
import java.util.*;
/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/18
 */
public class LC442 {
    public static void main(String[] args) {

    }
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if (nums[Math.abs(nums[i])-1]<0){
                list.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        return list;
    }
    public List<Integer> findDuplicates1(int[] nums) {
        // 这个方法，最后排好的数组，位置上的数不是理应出现的数的位置上存的其他正确位置（值不止一个）多出来的数。
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {//当前数字 本就出现在理应的位置上，跳过，不用换。
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int idealIdx = nums[i] - 1;
            if (nums[i] == nums[idealIdx]) {//当前数字 理应出现的位置上，已经存在当前数字，跳过，不用换。
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(nums[j]);
            }
        }
        return res;
    }
}
