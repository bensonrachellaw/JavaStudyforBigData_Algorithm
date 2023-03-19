package ExamMT;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        int cnt = 0;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)==' ') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
//    String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
}
