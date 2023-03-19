package ExamTX;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();
        String s = reader.nextLine();
        String ss = "2"+s;
        long w = 0;
        long v = 0;
        for (int i = 1;i<ss.length();i++){
            if (ss.charAt(i)=='0'){
                w += i;
            }
            else {
                v += i;
            }
        }
        int a = Integer.MAX_VALUE;
        long max  =  Math.abs(v);
        long W = 0;
        long V = 0;
        for (int i = 1;i<ss.length();i++){
            if (ss.charAt(i)=='0'){
                W += i;
            }
            else {
                V += i;
            }
            long temp = v-V;
            max = Math.min(Math.abs(temp-W),max);
        }

        System.out.println(max);
    }
}
