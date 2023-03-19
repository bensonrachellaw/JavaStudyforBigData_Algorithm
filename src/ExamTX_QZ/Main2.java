package ExamTX_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/10/16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        long m = reader.nextLong();
        StringBuilder s = new StringBuilder("10");
        int i = 0;
        while (i<4){
            s.append(solution(s));
            i++;
        }
        String ss = s.toString();
        long cnt =0;
        for (long j = n-1;j<=m-1;j++) {
            if (ss.charAt((int)j)=='1') {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    private static String solution(StringBuilder s){
        String ss = s.toString();
        StringBuilder t = new StringBuilder("");
        for (int i = 0;i<ss.length();i++) {
            String temp = "";
            if (ss.charAt(i)=='0'){
                temp = "1";
            }
            else {
                temp = "0";
            }
            t.append(temp);
        }
        return t.toString();
    }
}
