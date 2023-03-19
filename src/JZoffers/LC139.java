package JZoffers;

import java.util.*;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/6/6
 * LC139:单词拆分（DP最容易理解）
 */
public class LC139 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
//        完全背包问题，字符串就是容量，物品是单词
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1;i<=s.length();i++){
            for (int j = 0;j<i;j++){//枚举分割点，两部分都要满足才行，一个前j个满足，然后字符串的j-i的部分又能匹配。
                if (dp[j] && set.contains(s.substring(j,i))){//左闭右开的
                    dp[i] = true;
                    break;//有一个方案合法就可以了。
                }
            }
        }
        return dp[s.length()];
    }
}
