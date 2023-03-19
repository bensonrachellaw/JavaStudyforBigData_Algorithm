package ExamMT_QZ;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        StringBuilder s = new StringBuilder("MeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwow");
        for (int i = 0;i<1000000;i++) {
            s = s.append(s.reverse()).append("wow");
        }
        for (int i = 0;i<T;i++) {
            long k = reader.nextLong();
            System.out.println(s.charAt((int) (k+1)));
        }
    }
}
