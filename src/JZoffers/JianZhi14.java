package JZoffers;

public class JianZhi14 {
    //快速幂求余。
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        long mod = 1000000007;
        if (n<=3) return n-1;
        int num = n/3 - 1;
        long base = 3;
        long res = 1;
        while(num>0) {
            if (num % 2==1) res = res * base % mod;
            base = base * base % mod;
            num = num / 2;
        }
        if (n%3==0) res = res * 3 % mod;
        if (n%3==1) res = res * 2 * 2 % mod;
        if (n%3==2) res = res * 3 * 2 % mod;
        return (int)(res % mod);
    }
}
