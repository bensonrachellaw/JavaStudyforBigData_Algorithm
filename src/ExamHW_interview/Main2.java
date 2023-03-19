package ExamHW_interview;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/22
 * 力扣679 《24点游戏》并输出所有的符合条件的序列。https://leetcode.cn/problems/24-game/solution/jin-jie-fan-hui-jie-guo-bing-qie-da-yin-xcl05/
 * 思路是先拿两个出来做运算然后放回去，然后整个过程4个数变3个数变2个数最后变一个数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println();
    }
    private static final int TARGET = 24;
    private static final double P = 1e-6;//因为涉及除法

    public boolean judgePoint24(int[] cards) {
        if (cards == null || cards.length != 4) return false;
        double[] a = new double[4];
        int i = 0;
        for (int num : cards) {
            a[i++] = (double) num;
        }
        return solve(a);
    }

    private boolean solve(double[] a) {
        int n = a.length;
        if (n == 1) {
            return Math.abs(TARGET - a[0]) <= P;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] b = new double[n - 1];
                int index = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        b[index++] = a[k];
                    }
                }
                for (double d : compute(a[i], a[j])) {//遍历抽出来两个数所有可能的计算结果，然后再放回b数组里面。
                    b[index] = d;
                    if (solve(b)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> compute(double x, double y) {
        //两个数有多种情况，相减和相除是需要考虑顺序的。相加和相乘不用。
        List<Double> ans = new ArrayList<>();
        ans.add(x + y);
        ans.add(x - y);
        ans.add(y - x);
        ans.add(x * y);
        if (y != 0) {
            ans.add(x / y);
        }
        if (x != 0) {
            ans.add(y / x);
        }
        return ans;
    }


}
