package ExamRY;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        int i = 0;
        while ((myPow(2,i)) <= n){
            i++;
        }
        System.out.println(i-1);
    }
    public static double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        if(x == 0) return 0;
        if (n>0){
            double res = 1.0;
            long b = n;
            while(b!=0){
                if ((b&1)==1) res *= x;
                x *= x;
                b = b >> 1;
            }
            return res;
        }
        if (n<0){
            double res = 1.0;
            long b = n;
            b = -b;
            while(b!=0){
                if ((b&1)==1) res *= x;
                x *= x;
                b = b >> 1;
            }
            return 1.0/res;
        }
        return 0;
    }

}
