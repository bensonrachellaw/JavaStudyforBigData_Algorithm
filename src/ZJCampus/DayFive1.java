package ZJCampus;

public class DayFive1 {
    public static void main(String[] args) {
        System.out.println(reverse(-456789153));
    }
    public static int reverse(int num){
        //因为x本身会被int限制，当x为正数并且位数和Integer.MAX_VALUE的位数相等时首位最大只能为2
        //题目要求不允许使用 64 位整数，即运算过程中的数字必须在 32 位有符号整数的范围内，因此我们不能直接按照上述式子计算，需要另寻他路。
        //Integer.MIN_VALUE = -2147483648;Integer.MAX_VALUE = 2147483647
        //记 res 为翻转后的数字，为完成翻转，我们可以重复「弹出」x 的末尾数字，将其「推入」res 的末尾，直至 x 为 0。
        int res = 0;
        while (num != 0){
            if (res < Integer.MIN_VALUE / 10  || res > Integer.MAX_VALUE / 10 ){
                return 0;
            }
            int digit = num % 10;//java的机制是使商尽可能大。所以比如-123 % 10 = -3 （因为商这时是-12 ，如果余数是7，商就要为-13，比-12小，所以不会是-13。)
            num = num / 10;
            res = res * 10 + digit;
        }
        return res;
    }
    //评论：恕我直言，凡是用了long的，都是钻空子的人。明明说了假设不能存储64位。
}
