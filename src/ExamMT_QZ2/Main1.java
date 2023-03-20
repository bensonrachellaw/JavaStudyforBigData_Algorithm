package ExamMT_QZ2;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int t = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }
        Arrays.sort(a);
        int time = t , acc = 0;
        for (int i = 0;i<n;i++){
            if (time>a[i]) {
                acc++;
            }
            else {
                time += t;
            }
        }
        System.out.println(acc);
    }
}
