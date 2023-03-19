package ExamBilibili_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/1
 * 非此公司考试题《最长排序连续上升字段长度》只能70%
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        long[] a = new long[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextLong();
        }
        Arrays.sort(a);
        long[] prefix_a = new long[n-1];
        for (int i = 0;i<n-1;i++) {
            prefix_a[i] = a[i+1] - a[i];
        }
        long ans = 0;
        for (int i = 0;i<n-1;i++) {
            int temp = i;
            while (prefix_a[temp]==1) {
                temp++;
            }
            ans = Math.max(ans,temp-i + 1);
            i = temp;
        }
        System.out.println(ans);

    }
}
