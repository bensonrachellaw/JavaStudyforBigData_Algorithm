package ExamHW;

import java.util.LinkedList;

public class LC1190 {
    /**
     * 给定一个字符串 s（仅含有小写英文字母和括号），按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     * @param args
     */
    public static void main(String[] args) {

    }
    public String reverseParentheses(String s) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else if (s.charAt(i)==')'){
                sb.reverse();
                sb.insert(0,stack.pop());
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public String reverseParentheses1(String s) {
        char[] arr = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0;i<arr.length;i++){
            if (arr[i]=='('){
                stack.push(i);
            }
            else if (arr[i]==')'){
                int index = stack.pop();
                reverse(arr,index+1,i-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr){
            if (c!='(' && c!=')'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private static void reverse(char[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);//把升序转为逆序。或者把逆序转为升序。
        }
    }

    private static void swap(char[] nums, int i, int i1) {
        char tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
