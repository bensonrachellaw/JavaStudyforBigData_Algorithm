package ExamWY_QZ;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/27
 */

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        for (int i = 0;i<T;i++) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
            int t = n;
            int j = 1;
            while (t < m || ((j*t) - m ) % 2 == 1) {//??
                j++;
                t = n * j;
            }
            StringBuilder[] sArr = new StringBuilder[t];
            for (int k = 0;k<n;k++) {
                sArr[k] = new StringBuilder(reader.nextLine());
            }
            if (i<T-1) {
                String xx = reader.nextLine();
            }
            //deal
            int jj = t/n;
//            System.out.println(jj);
            for (int k = 0;k<n;k++) {
                StringBuilder temp = new StringBuilder("");
                int kk = 1;
                while (kk<=jj) {
                    temp.append(sArr[k]);
                    kk++;
                }
                sArr[k] = temp;
            }
            for (int k = n;k<t;k++) {
                sArr[k] = sArr[k-n];
            }
            int oo = (t-m)/2;
            for (int k = oo;k<t-oo;k++) {
                System.out.println(sArr[k].substring(oo,t-oo));
            }
            System.out.println();
        }
    }
}
