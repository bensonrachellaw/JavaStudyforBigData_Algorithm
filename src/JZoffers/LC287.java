package JZoffers;

import java.util.Arrays;
import java.math.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/6
 * LC287《寻找重复数》
 */
public class LC287 {
    public static void main(String[] args) {
        System.out.println(1 << 50);//打印超出int值的范围时会去掉多余的位，重新计算
    }
    //正确做法：从下面搬上来的，怕太下面会看不到
    public int findDuplicate_QS_copy(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];//142 题中慢指针走一步 slow = slow.next ==> 本题 slow = nums[slow]
            fast = nums[nums[fast]];//142 题中快指针走两步 fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
        } while (slow != fast);
        slow = 0;//其中一个指针回到起点，
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;//返回相遇点
    }

    //排序做法：
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-1;i++) {
            if (nums[i]==nums[i+1]) {
                return nums[i];
            }
        }
        return 0;
    }

    //位运算方法。数据大就AC不了
    public int findDuplicate_bit1(int[] nums) {
        long tol = 0;
        for (int num : nums) {
            long temp = tol;
            tol = tol ^ (1 << num);
            if (tol < temp) {
                return num;
            }
        }
        return 0;
    }
    //位运算方法使用了BigInteger类，因为超过long能表示的范围
    public int findDuplicate_bit2(int[] nums) {
        BigInteger biginteger = new BigInteger("0");
        for (int num : nums) {
            BigInteger temp = new BigInteger(String.valueOf(num));
            if (biginteger.compareTo(biginteger.xor(temp)) < 0) {
                return num;
            }
            biginteger = biginteger.xor(temp);
        }
        return 0;
    }
    // 二分答案法，对答案(1-n)进行二分, 在 [1..n] 查找 nums 中重复的元素
    public int findDuplicate_bi(int[] nums) {

        int n = nums.length;//nums.length为N+1
        int l = 0;
        int r = n;

        while (l+1<r) {
            int mid = (l+r) >> 1;

            int cnt = 0;//计算整个数组中比mid要小或者相等的数的数量。
            for (int num : nums) {
                if (num<=mid) {
                    cnt++;
                }
            }

            if (cnt>mid) {
                r = mid;
            }else {
                l = mid;
            }
        }
        return l;

    }
    //数组下标 n 和数 nums[n] 建立一个映射关系 f(n).从下标找数，再用数当作下标去继续去找。
    //用环形链表II的方法解题（142.环形链表II:找环的入口节点），使用 142 题的思想来解决此题的关键是要理解如何将输入的数组看作为链表。
    //在本题中环的入口节点不可能为0，因为数组中没有数为0，就构不成一个死循环：死循环的意思，1号下标的元素值为2，2号下标的元素值为1，这样就相当于一个环。

    public int findDuplicate_QS(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];//142 题中慢指针走一步 slow = slow.next ==> 本题 slow = nums[slow]
            fast = nums[nums[fast]];//142 题中快指针走两步 fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
        } while (slow != fast);
        slow = 0;//其中一个指针回到起点，
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;//返回相遇点
    }
}
