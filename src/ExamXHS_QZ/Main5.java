package ExamXHS_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/25
 *
 * 检查是否可以通过从string1删除一些字符而不重新排列任何字符串的字符来形成string2
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();
        for (int i = 0;i<n;i++){
            String a = reader.nextLine();
            String b = reader.nextLine();
            if (solution(a,b)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean solution (String a, String b) {
        if (b.length() > a.length()) return false;
        for (int i = 0 ;i < b.length();i++) {
            char t = b.charAt(i);
            int index = a.indexOf(t);//找到第一个出现的字符的下标
            if (index!=-1){//如果不是没找到的话，就代表有这个字符。
                a = a.substring(index+1);//左闭的，index+1到末尾
                continue;
            }
            return false;
        }
        return true;
    }
}
