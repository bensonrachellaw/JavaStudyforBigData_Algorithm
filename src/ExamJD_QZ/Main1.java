package ExamJD_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/2
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        Arrays.sort(a);
        int x = a[n-1];
        int ans = 0;
        for (int i = 0;i<n;i++) {
            if (a[i]==x){
                ans++;
            }
        }
        System.out.println(ans);
//        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
    }
}
