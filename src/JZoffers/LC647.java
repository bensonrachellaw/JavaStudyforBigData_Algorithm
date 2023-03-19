package JZoffers;

public class LC647 {
    public static void main(String[] args) {

    }
    public static int countSubstrings(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        //i表示子串的左端点，j表示子串的右端点。
        for (int i = s.length()-1; i >= 0; i--) {//按先行后列的方式，且行要先填后面的，列要先填前面的。
            for (int j = i; j < s.length() ; j++) { // 修改
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
    //整个二维矩阵是只填充了右上角。

    //中心扩展法：
    static int num = 0;
    public static int countSubstrings2(String s) {
        for (int i = 0;i<s.length();i++){
            count(s,i,i);//回文串长度为奇数
            count(s,i,i+1);//回文串长度为偶数
        }
        return num;
    }

    public static void count(String s ,int l ,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            num++;
            l--;
            r++;
        }
    }
}
