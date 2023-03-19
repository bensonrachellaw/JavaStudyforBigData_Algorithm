package ZJCampus;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class DayTen3 {
    public static void main(String[] args) {
        System.out.println(decodeString("3(a2(c))3(a)2(bc)"));
    }

    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder("");
        LinkedList<Integer> k = new LinkedList<>();
        LinkedList<String> stack = new LinkedList<>();
        int multi = 0;
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                multi = multi*10 + (c-'0');
            }
            else if (c=='('){
                k.addLast(multi);
                stack.addLast(ans.toString());
                multi = 0;
                ans = new StringBuilder("");
            }
            else if (c==')'){
                int kNum = k.pollLast();
                StringBuilder temp = new StringBuilder(ans.toString());
                for (int i = 0;i<kNum-1;i++) temp.append(ans.toString());
                ans = new StringBuilder(stack.pollLast()+temp);
            }
            else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
