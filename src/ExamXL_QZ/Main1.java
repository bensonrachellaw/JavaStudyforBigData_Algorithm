package ExamXL_QZ;

import java.util.Scanner;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/19
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        for (int i = 0;i<t ;i++){
            int n = reader.nextInt();
            String x = reader.nextLine();
            String[] s = new String[n];
            for (int j = 0;j<n;j++) {
                s[j] = reader.nextLine();
            }

            int tag1 = 0;
            for (int j = 0 ; j<n-1;j++) {
                for (int k = j+1;k<n;k++) {
                    int tag = 0;
                    int min = Math.min(s[j].length(),s[k].length());
                    for (int m = 0;m<min;m++) {
                        if (s[j].charAt(m)!=s[k].charAt(m)) {
                            tag=1;
                            break;
                        }
                    }
                    if (tag==0) {
                        tag1=1;
                    }
                }
            }
            if (tag1==1) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }

        }
    }

}
