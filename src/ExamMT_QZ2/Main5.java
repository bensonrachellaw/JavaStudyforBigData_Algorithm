package ExamMT_QZ2;
import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n+1];
        for (int i = 1;i<=n;i++){
            a[i] = reader.nextInt();
        }
        int[] dp = new int[n+1];
        dp[1] = a[1];
        int max = -1;
        for (int i = 2;i<=n;i++){
            dp[i] = dp[i/2] + a[i];
            max = Math.max(max,dp[i]);
        }
        System.out.print(max);
    }
}
