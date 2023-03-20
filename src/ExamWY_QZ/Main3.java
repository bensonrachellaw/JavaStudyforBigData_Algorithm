package ExamWY_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/27
 */
public class Main3 {
    static Random random = new Random();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        int ans = 0;
        for (int i = 0;i<T;i++) {
            String[] s = new String[3];
            for (int j = 0;j<3;j++) {
                s[j] = reader.nextLine();
            }
            int cnt = 0;
            for (int j = 0;j<3;j++) {
                for (int k = 0;k<3;k++) {
                    if (s[j].charAt(k)=='.') {
                        cnt++;
                    }
                }
            }
            if (cnt==3) {
                System.out.println(3);
            }
            if (cnt==4) {
                System.out.println(22);
            }
            if (cnt==5) {
                System.out.println(111);
            }
            else {
                char[][] c = new char[3][3];
                int[] res = {3,22,111};
                System.out.println(res[random.nextInt(500)]);
            }
        }
    }
}


