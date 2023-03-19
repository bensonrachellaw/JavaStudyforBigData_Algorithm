package JZoffers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/16
 */
public class LC402 {
    public static void main(String[] args) {

    }
    public String removeKdigits(String num, int k) {
        char[] a = num.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        //用了队列的api（方法）
        stack.offer(a[0]);
        for (int i = 1;i<a.length;i++){

            char c = a[i];
            while (!stack.isEmpty()&&stack.peekLast() > c&&k>0){
                stack.pollLast();
                k--;
            }
            stack.offer(c);


        }
        while (k>0){
            stack.pollLast();
            k--;
        }
        //贪心+单调栈
        //从左到右，找第一个比后面大的字符，删除，满足够k次删除,最后执行一次清零
        //如果用pop和peek和push的话，栈顶是向着左边的(转为字符串时需注意)。是栈的方法。
        //所有删除完最后才开始执行一次清除前导零。
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();//弹出第一个
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
