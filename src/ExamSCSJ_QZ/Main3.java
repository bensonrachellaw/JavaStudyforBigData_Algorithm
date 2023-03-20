package ExamSCSJ_QZ;
import java.util.*;

/**
 * 题目:每天的股价用一个整数表示，用一个整数数组表示连续n天的股价，数组的下标表示第几天。现需要计算一个指标X，X的定义为：任意两天的股价之和 - 此两天的间隔天数。
 *  问 ： 找出指标X的最大值，即：MAX 【Xi+Xj - （j-i）】 其中（j>i）
 *  转译：找出数组中 任意两个数之和减去他们之间的距离 的最大值。
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        long max = -1;
        for (int i = 0;i<n;i++) {
            for (int j = i+1;j<n;j++) {
                max = Math.max(max,a[j]+a[i]-(j-i));//暴力遍历全部任意两个数。超时。
            }
        }
        System.out.println(max);
        System.out.println(solution(a));
    }

    /**
     * O（n）解法：对 f(x) = Xi+Xj - （j-i） 进行移项转换。变成 (Xi + i) + (Xj - j) ,要求这个的最大值。所以就是求(Xi + i)的最大值和(Xj - j)的最大值，两个都要最大。
     * 所以只需要维护两个max变量，一个是最后答案的max，一个是当前数前面那一堆的最大的(Xi + i)
     * @param nums 原数组
     * @return max
     */
    public static int solution(int[] nums) {
        int max_pre = nums[0] + 0;//第一个(Xi + i)
        int max = 0;//代表答案的max
        for (int i = 1 ;i<nums.length;i++) {
            max = Math.max(max,nums[i]-i + max_pre);
            max_pre = Math.max(max_pre,nums[i]+i);
        }
        return  max;
    }
}
