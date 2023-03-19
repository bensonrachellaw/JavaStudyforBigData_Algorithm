package ExamZJ_QZ;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] s = reader.nextLine().split(" ");
        int[] a = new int[s.length+1];
        for (int i = 0;i<s.length;i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int tag = 0;
        int cnt = 0;
        for (int i = 0;i<=s.length;i++) {
            int x = a[i] % 4;
            int y = a[i] / 4;
            cnt += y;

            if (x==1) {

                if (a[i+1]==3){

                }
                else {
                    a[i+1] = a[i+1]-2;
                }
                cnt++;
            }
            if (x==2){
                if (a[i+1]==3){

                }
                else {
                    a[i+1] = a[i+1]-2;
                }
                cnt++;
            }
            if (x==3){
                if (a[i+1]==2){

                }
                else {
                    a[i+1] = a[i+1]-1;
                }
                cnt++;
            }
        }
        System.out.println(cnt-1);
    }
}
