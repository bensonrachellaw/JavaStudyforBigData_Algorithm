package ExamMT_QZ2;
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0;i<n;i++){
            list.add(a[i]);
        }
        for (int i = 0;i<n;i++){
            int x = list.removeLast();
            int y = list.removeLast();
        }
    }
}
