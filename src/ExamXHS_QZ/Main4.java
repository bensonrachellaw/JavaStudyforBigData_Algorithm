package ExamXHS_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/25
 *
 *
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = reader.nextInt();
        }
        int[] vis = new int[10000000];
        for (int i = 0;i<n;i++) {
            vis[arr[i]] = 1;
        }
        int temp = 0;
        for (int i = 1;i<10000000;i++) {
            if (vis[i]==0) {
                temp = i - 1;
                break;
            }
        }
        System.out.println(temp);
    }
}
