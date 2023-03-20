package ExamBilibili_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/1
 * 一个自然数可以分解为若干个自然数相乘，给一个自然数N，求出每种分解自然数N的策略中，所有数之和最少的一个，如12=2*2*3，和为7=2+2+3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (isPrime(n)) {
            System.out.println(n);
        }
        else {
            int R = (int) Math.sqrt(n);
            int div = 2;
            int sum = 0;
            while(true) {
                if (div > R) {
                    break;
                }
                if (n%div==0) {
                    sum += div;
                    n /= div;
                    R = (int) Math.sqrt(n);
                }
                else{
                    div++;
                }
            }
            System.out.println(sum+n);
        }
    }
    //判断一个数是否为质数（素数）取根号是因为一个数n所有质因数中只有一个大于根号n的。
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }
}

