package ExamMT_QZ3;

import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0;i<n;i++) {
            arr[i][0] = reader.nextInt();
        }
        for (int i = 0;i<n;i++) {
            arr[i][1] = reader.nextInt();
        }
        Arrays.sort(arr,(o1,o2)->(o2[1]*(100-o2[0]) - o1[1]*(100-o1[0])));//int[][]也能这样排序。从大到小。
        double ans = 0;
        for (int i = 0;i<m;i++) {
            ans+=arr[i][1]*100;
        }
        for (int i = m;i<n;i++) {
            ans+=arr[i][1]*arr[i][0];
        }
        ans/=100;
        System.out.printf("%.2f",ans);
    }
}