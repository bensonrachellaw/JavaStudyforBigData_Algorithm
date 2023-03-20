package JZoffers;

import java.util.Arrays;

public class JianZhi46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
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
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=s.length();i++){
            dp[i] += dp[i-1];
            if (s.charAt(i-2)=='1' || (s.charAt(i-2)==2&&s.charAt(i-1)<='5')) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}
