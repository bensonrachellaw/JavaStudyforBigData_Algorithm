package ExamMT_QZ3;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/27
 */
public class Mainelse {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            list.add(i+1);
        }
        int[] arr = new int[m];
        for (int i = 0;i<m;i++) {
            arr[i] = reader.nextInt();
        }
        for (int i = 0;i<m;i++) {
            list.remove((Integer)arr[i]);
            list.add(0,(Integer) arr[i]);
        }
        String[] ans = new String[n];
        for (int i = 0;i<n;i++) {
            ans[i] = String.valueOf(list.get(i));
        }
        System.out.println(String.join(" ",ans));
    }
}
