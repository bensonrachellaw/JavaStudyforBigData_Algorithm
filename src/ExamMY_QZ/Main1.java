package ExamMY_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/15
 * 思路：求x的所有质因子个数,求正整数N(N>1)的质因数的个数。 相同的质因数需要重复计算！！！如120=2*2*2*3*5
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1;i<=1000000000;i++){
            if (isPrime(i)){
                set.add(i);
            }
        }
        for (int i = 0;i<t;i++) {
            int n = reader.nextInt();
            if (PrimeNum(n)%2==1) {//奇数个，先手的赢
                System.out.println("先手的赢");
            }
            else {//偶数个，后手的赢
                System.out.println("后手的赢");
            }
        }
    }


    //求n的所有质因子个数，质因数可以重复使用这点挺关键的，每次被质因数整除完，继续被相同质因数整除，直到整除不了再往下走。如120=2*2*2*3*5，共有5个质因数。

    /**
     * 第一种方法：打表。先把素数表打好
     * 写一个判断一个数是否为质数的函数，用数组prime[ ]把5000以内的质数按从小到大的顺序存储起来。
     * 输入N，判断N是否为质数，如果是进入循环，用N除以prime[i]，如果能整除，sum++，N=N/prime[i],否则把除数换成prime[i++] 。
     * N为质数时退出循环，输出sum。
     *
     * 第二种方法：循环判断法，如代码中所示。重复的需要计算
     *
     *
     */
    public static int PrimeNum(int N) {
        int cnt = 0;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            while (N % d == 0) {
                cnt++;
                N = N / d;
            }
        }
        // 存在大于 sqrt(N) 的因子，最后还剩一个质数所以除不到1，那么这个质数也是一个因子。
        if(N > 1) cnt++;
        return cnt;
    }
    //判断一个数是否为质数（素数）取根号是因为一个数n所有质因数中只有一个大于根号n的。
    public static boolean isPrime(int N) {
        if (N < 2) return false;//2是最小的质数。1不是质数。质数是指在大于1的自然数中,除了1和它本身以外不再有其他因数的自然数。
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

}
