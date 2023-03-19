package ExamJD_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/2
 * 题目概括： x可以拆成x-1,1 或 a,b (a*b=x) ; 将数组中每个数字全拆成1的最少操作次数
 *
 * 题目描述：小红的数字分裂 求得到数组中元素全部为1的最少操作数， 小红一次可以选择一个数进行以下两种操作
 * A:将数字 x 分裂为 1 和 x - 1
 * 或者
 * B:将数字 x 分裂为 a 和 b， a 和 b的条件必须满足 a * b == x
 *
 * n 为数组中数字的个数
 * data[i] 数组中的数字大小
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        //怎么就没想到动态规划思想呢？？？
        long ans = 0;
        Arrays.sort(a);//求出a中的最大数来初始化dp数组
        long[] dp = new long[a[n-1]+1];//dp数组为每个<=10^5的数经过两个操作后变成一堆1的最少操作次数。记忆化的一个思想。

        dp[1] = 0;//1不用分裂
        for (int i = 2;i<dp.length;i++) {
            dp[i] = dp[i-1] + 1;//做一次A操作的结果，如果当前分裂的数是个质数，那就只能是做第一种操作了
            for (int j = 2; j <= Math.sqrt(i); j++) {
                //j * (i/j) = i。遍历当前数的所有因数（相乘等于当前数的两个数）的dp值+1 ，取最小的。
                if (i%j==0) {//如果是质数，不会进入if里面。
                    dp[i] = Math.min(dp[i],dp[i/j]+dp[j]+1);
                }
            }
        }

        //最后把每个数的最少分裂次数加起来就是总的最少分裂次数
        for (int i = 0; i < n; i++) {
            ans += dp[a[i]];
        }
        System.out.println(ans);
    }
}
