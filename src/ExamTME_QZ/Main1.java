package ExamTME_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/8
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println(minOperations("abab"));
    }
    public static int minOperations (String str) {
        // write code here
        int[] cnt = new int[200];
        for (int i = 0;i<str.length();i++) {
            cnt[str.charAt(i)]++;
        }
        int ans = 0;
        int a = 0;
        while (a==0) {
            for (int i = 97;i<=122;i++) {
                if (cnt[i] > 1) {
                    while (cnt[i] >= 2) {
                        cnt[i] = cnt[i] - 2;
                        int tmin = 2000;
                        int tag = 0;
                        for (int k = 97;k<=122;k++) {
                            if (cnt[k] < tmin) {
                                tmin = cnt[k];
                                tag = k;
                            }
                        }
                        cnt[tag] += 1;
                        ans++;
                    }
                }
            }
            int b = 0;
            for (int i = 97;i<=122;i++) {
                if (cnt[i] <= 1) {
                    b++;
                }
            }
            if (b==26) {
                a = 1;
            }
        }
        return ans;
    }

}
