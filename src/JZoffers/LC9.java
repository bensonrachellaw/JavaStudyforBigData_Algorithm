package JZoffers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/2
 */
public class LC9 {
    public static void main(String[] args) {

    }
    //回文数是正反完全相等的数。
    public static boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        if (x>=0 && x<=9) {
            return true;
        }
        Deque<Integer> stack = new LinkedList<>();
        int y = x;
        while (y>0) {
            int temp = y%10;
            stack.offer(temp);
            y = y / 10;
        }
        while (!stack.isEmpty()) {
            int tmp1 = stack.pollLast();
            int tmp2 = x % 10;
            if (tmp1!=tmp2) return false;
            x = x /10;
        }
        return true;
    }
    //评论做法：
    //即使反转后溢出也不怕，因为溢出就变负数了肯定不相等。
    public boolean isPalindrome1(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
