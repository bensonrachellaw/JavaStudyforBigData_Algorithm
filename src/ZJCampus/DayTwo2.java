package ZJCampus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DayTwo2 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        //相当于r一次遍历。再加l的重复元素的数量。
        int[] array = new int[130];//记录字符的最新下标位置。
        Arrays.fill(array,-1);

        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            if(array[s.charAt(r)]>=l){
            //如果上一次最新的位置已经超过左边界，就说明在当前这一段存在重复的字符。因此左指针就要跳。但不是一步步跳，直接跳到重复字符的上一次最新的位置的后一个位置即可，
            //这样就可以摆脱掉重复字符的重复项，因为一步步跳其实是无效的，不能迅速摆脱重复字符
                l = array[s.charAt(r)]+1;
            }
            max =Math.max(max,r-l+1);//更新无重复字符的最长子串的长度，只在右指针往右扩展的时候更新即可，左指针往右跳时会缩小边界，也就是缩小长度。所以左指针往右跳的时候不需要，没必要比较了，因为肯定是缩短的。
            //可以改造为if else语句
            array[s.charAt(r)] = r;//更新当前右指针指向字符的最新下标位置。右指针的每步都要更新。
            r++;//右指针往右走。
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
