package ZJCampus;

public class DayEleven2 {
    public static void main(String[] args) {

    }

    public String longestPalindrome_dp(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlenth = 0;
        int l = 0 ,r = 0;
        //i表示子串的左端点，j表示子串的右端点。
        for (int i = s.length()-1; i >= 0; i--) {//按先行后列的方式，且行要先填后面的，列要先填前面的。
            for (int j = i; j < s.length() ; j++) { // 修改
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j-i+1>maxlenth){
                        maxlenth = j-i+1;
                        l = i;
                        r = j;
                    }
                }
            }
        }

        return s.substring(l,r+1);
    }
    //整个二维矩阵是只填充了右上角。
    public String longestPalindrome(String s) {
        int min = Integer.MIN_VALUE;
        int l = 0 ,r = 0;
        for (int i = 0;i<s.length();i++){
            int[] x = count(s,i,i);//回文串长度为奇数
            int[] y = count(s,i,i+1);//回文串长度为偶数
            if (x[1]-x[0]+1>min){
                min= x[1]-x[0]+1;
                l = x[0];
                r = x[1];
            }
            if (y[1]-y[0]+1>min){
                min= y[1]-y[0]+1;
                l = y[0];
                r = y[1];
            }
        }
        return s.substring(l,r+1);//返回最长的回文子串。
    }
    public int[] count(String s ,int l ,int r){//不同于DP做法，中心拓展是以中心向两边扩展搜寻。
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return new int[]{l+1,r-1};//注意细节，只需返回每个中心点的最长回文子串即可，因为里面的包含的回文子串肯定没有最长的长
    }

}
