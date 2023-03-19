package ExamMT;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int h1 = reader.nextInt();
        int m1 = reader.nextInt();
        int h2 = reader.nextInt();
        int m2 = reader.nextInt();
        int a = h1*60 + m1;
        int b = h2*60 + m2;
        int ans = b - a;
        System.out.println(ans);
    }
}
