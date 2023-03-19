package ExamXL_QZ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/19
 * 给定一个数n，和一个max，求最少需要几步将1正好等于n，（有两种方式：1、将这个数加1；2、将这个数*2）其中方式2最多用max次。
 * LC2139 得到目标值的最少行动次数 贪心 逆向思维，奇数先减1，若maxDoubles>0,再除2
 * 题目要求1到target。我们可以反过来考虑这个游戏，目标是将给定的整数 target 变为 1；
 * 如果当前整数为奇数，那么我们必须只能执行递减操作；在当前整数为偶数时，我们应当贪心地执行折半操作。直到为1
 *
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] s = reader.nextLine().split(",");
        int[] a = new int[s.length];
        for (int i = 0;i<s.length;i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int t = a[0] , m = a[1];
        int cnt = 0;

        while (t > 1 && m > 1) {
            if (t%2==1) {
                cnt++;
                t--;
            }
            if (t>1) {
                t = t / 2;
                cnt++;
                m--;
            }
        }
        if (t>1) {
            cnt += t - 1;
        }
        System.out.println(cnt);
    }

}
