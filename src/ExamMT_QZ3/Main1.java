package ExamMT_QZ3;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        String a = reader.nextLine();
        String b = reader.nextLine();
        StringBuilder s = new StringBuilder("");
        for (int i = 0;i<n;i++) {
            s.append(a.charAt(i));
            s.append(b.charAt(i));
        }

        System.out.println(s.toString());
    }
}
