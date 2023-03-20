package JZoffers;

import java.util.*;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/18
 */
public class LC448 {
    public static void main(String[] args) {

    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //普通替换需要额外用一个序列数组
        //所以才有用自身数组元素的负数作为替换字符的方法，这样被替换字符也可以继续作为索引值使用；节省了一个数组空间；
        //不一定需要用负数来还原，也可以用加n然后对n取模来还原出它本来的值。
        //还可以像LC41的做法一样：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solution/shou-hua-tu-jie-jiao-huan-shu-zi-zai-ci-kzicg/
        //上述的这个方法，最后排好的数组，位置上的数不是理应出现的数的位置上存的其他正确位置（值不止一个）多出来的数。
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        /**
         遍历数组，将每个数字交换到它理应出现的位置上，下面情况不用换：

         当前数字 本就出现在理应的位置上，跳过，不用换。
         当前数字 理应出现的位置上，已经存在当前数字，跳过，不用换。

         这个方法，最后排好的数组，位置上的数不是理应出现的数的位置上存的其他正确位置（值不止一个）多出来的数。
         */
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
                res.add(j + 1);
            }
        }
        return res;
    }
}
