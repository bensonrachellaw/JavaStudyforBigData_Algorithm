package ExamXHS_QZ;

import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/28
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        long k = reader.nextLong();
        long[] arr = new long[n];
        for (int i = 0;i<n;i++) {
            arr[i] = reader.nextLong();
        }
//        Arrays.sort(arr);
        long cnt = 0;
        for (int i = 0;i<n;i++) {
            for (int j = i+1;j<n;j++) {
                    if (arr[i] * arr[j] >= k) {
                        cnt++;
                    }
            }
        }
        System.out.println(cnt*2);
    }
}