package JZoffers1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/12/7
 */
public class offer59 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        int ans = dp_solve(s);
        System.out.println(ans);
    }

    public static int dp_solve(String s){
        char[] ch = s.toCharArray();
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=s.length();i++){
            dp[i] += dp[i-1];
            if (ch[i-2]=='0' || ch[i-2]>'2'){

            }
            else {
                if (ch[i-2]=='2' && ch[i-1]>'5'){

                }
                else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}
