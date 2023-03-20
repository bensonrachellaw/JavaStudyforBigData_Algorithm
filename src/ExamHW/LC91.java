package ExamHW;

public class LC91 {
    //解码方法：此题与剑指offer46题的区别是0是否映射！本题不映射。
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        int k = 0;
        while(k < s.length() && s.charAt(k)=='0') k++;
        if (k>0) return 0;
        String ss = s.substring(k);
        int[] dp = new int[ss.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=ss.length();i++){
            if (ss.charAt(i-1) == '0' && ss.charAt(i-2) == '0') return 0;//解决连续两个0的问题；肯定无法映射，所以返回0；
            if (ss.charAt(i-1) == '0' && ss.charAt(i-2) > '2') return 0;//解决遇到0但是0前面的数大于2了，所以也无法映射。
            if (ss.charAt(i-1) == '0' && ss.charAt(i-2) < '3') {//解决遇到0且0前面的数为1或2，因为0不能独自匹配，所以只能和前面的匹配，因此为dp[i] = dp[i-2];
                dp[i] = dp[i-2];
            }
            else if (ss.charAt(i-2) == '1' && ss.charAt(i-1) != '0') {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else if (ss.charAt(i-2)=='2' && ss.charAt(i-1)<'7' && ss.charAt(i-1) != '0'){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        return dp[ss.length()];
    }
}
