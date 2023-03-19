package ExamMT_QZ2;
import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = reader.nextInt();
        }
        HashMap<Integer,Integer>[] map = new HashMap[n];
        for (int i = 0;i<n;i++){
            map[i] = new HashMap<>();
        }
        for (int i = 0;i<n;i++){
            for (int j = i + 1;j<n;j++) {
                map[i].put(a[i]-a[j],map[i].getOrDefault(a[i]-a[j],0)+1);
            }
        }
        int ans = 0;
        for (int i = 0;i<n;i++){
            for (int j = i + 1;j<n;j++) {
                ans+= map[j].getOrDefault(a[i]-2*a[j],0);
            }
        }
        System.out.println(ans);
    }
}
