package JZoffers;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/22
 * 字典序就是小的在前面。
 *
 * 题目的要求总结出来有三点：
 *
 * 要求一、要去重。
 *
 * 要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
 *
 * 要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。
 *
 *
 * 思路：遇到一个新字符A 如果栈顶元素比A大，并且栈顶元素在字符串中A的后面还会再出现 就把栈顶的字符pop掉
 */
public class LC316 {
    public static void main(String[] args) {

    }
    public static String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0;i<s.length();i++) {
            char temp = s.charAt(i);
            if (stack.contains(temp)){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < temp && s.indexOf(stack.peek(),i) != -1) {
                stack.pop();
            }
            stack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
