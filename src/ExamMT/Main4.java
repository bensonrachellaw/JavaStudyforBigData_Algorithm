package ExamMT;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        int b = reader.nextInt();
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int cnt = 0;
        while (max!=min){
            if (max>=min*2) {
                max = max/2;
                cnt++;
            }
            else if (max-min > min*2 - max+1) {
                cnt += min*2 - max+1;
                max = min;
            }
            else {
                cnt+=max-min;
                max = min;
            }
        }
        System.out.println(cnt);
    }
    /**
     * 你是魔法学院中的一个学生。你在魔法课中因老师讲得无聊开始了开小差。你手中有两个数字A和B，你可以释放以下三种魔法：
     *
     * ①选择一个数字，让它变成原先的二倍，即，假如数字本来为n，释放此魔法后将变成2*n 。
     *
     * ②选择一个数字，让它变成原来的一半后向下取整，即，假如数字本来为n，释放此魔法后将变成n/2（向下取整），例：对4释放将变成2，对7释放将变成3（向下取整了）。
     *
     * ③选择一个数字，让它变成原来的值加一，即，加入数字本来为n，释放此魔法后将变成n+1.
     *
     *
     *
     * 这三种魔法你都可以任意次数使用，但你是追求完美的学生，你想用尽可能少的释放魔法次数让这两个数变得相等。
     * 输入描述
     * 第一行两个空格隔开的正整数A和B表示待操作的数。
     *
     * A<=1000,B<=1000
     *
     * 输出描述
     * 输出一行，表示让这两个数变得相等需要的最少操作次数。
     */
}
