package ZJCampus;

public class Day21_1 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
    //与小数相关的二分习惯性使用for加循环次数，一般100都可以的了。
    public static double mySqrt(int x) {
        if (x==0) return 0;
        double l = 0;
        double r = x+1.0;
        for (int i = 0;i<70;i++){
            double mid = (l+r)/2;
            if (mid*mid>x){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        return l;
    }
}
