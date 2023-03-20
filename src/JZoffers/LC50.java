package JZoffers;

public class LC50 {
    //剑指 Offer 16. 数值的整数次方 快速幂
    public static void main(String[] args) {

    }
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        if(x == 0) return 0;
        if (n>0){
            double res = 1.0;
            long b = n;
            while(b!=0){
                if ((b&1)==1) res *= x;//指数的二进制的最后一位是1的就是要乘这一个数，根据二进制去思考，如果是0就不要这一次翻倍的这个数
                x *= x;//每次翻倍，x x平方 x四次方这样
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
