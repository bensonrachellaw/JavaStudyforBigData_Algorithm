package ExamXL_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] s = reader.nextLine().split(" ");
        int[] a = new int[s.length];
        for (int i = 0;i<s.length;i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        long[] arr = new long[s.length];
        arr[0] = a[0];
        for (int i = 1;i<s.length;i++) {
            arr[i] = arr[i] + a[i];
        }
        int cnt = 0;
        for (int i = 0;i < s.length - 2;i++) {
            for (int j = i+1;j<s.length - 1;j++) {
                if (arr[i] <= arr[j] - arr[i] && arr[j] - arr[i] <= arr[s.length-1] - arr[j]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
