package ExamMT_QZ;
import java.util.*;

/**
 * 小美做饼干，有AB两种，做成礼盒卖，每个礼盒三个饼干，且至少包含一个A 和 一个B。现在给你A和B的数量，问最多可以做多少礼盒？
 * 给定a、b两种点心的数量，每个礼盒放3个点心，a、b至少各有一个，求最多能包多少个礼盒?
 * 8.6美团笔试没做出来，想错方法了。应该从公式入手理解。设2a1b礼盒有x个，2b1a礼盒有y个。两种怎么选要根据a，b的数量关系而决定，不一定全都是选一种！
 *
 * 如果a<2b或者b<2a:
 * 因此，设2a1b礼盒有x个，2b1a礼盒有y个，那么就有2x+y<=a   2y+x<=b,因此联立两个不等式，得3（x+y）<=a+b.
 * 所以，x+y<=（a+b）/3;这种情况就不一定全都是选一种！
 *
 * 如果a>=2b，则代表可以最多取b个礼盒。全选一种：2a+b
 * 如果b>=2a，则代表可以最多取a个礼盒。全选一种：2b+ant a = reader.nextInt();
 *             int b = reader.nextInt();
 *
 * 因此以上三种情况取最小值，得到短板，即如果少的部分能拿完，答案就是少的那部分，否则就是两者之和除以3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        for (int i = 0;i<T;i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int min = Math.min(Math.min(a,b),(a+b)/3);
            System.out.println(min);
        }
    }
}
