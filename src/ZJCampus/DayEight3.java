package ZJCampus;

import java.util.HashMap;
import java.util.HashSet;

public class DayEight3 {
    public static void main(String[] args) {

    }
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n<m){
            return "";
        }
        // 如果t比s还要长，那就不需要往下判断了。
        int[] sCnt = new int[130];
        int[] tCnt = new int[130];
//        使用ASCII码-'A'作为数组的下标，记录每个字符的数量
        for (int i = 0;i<m;i++){
            tCnt[t.charAt(i)-'A'] += 1;
            sCnt[s.charAt(i)-'A'] += 1;
        }
        //统计t的每个字符数量以及s中前m个字符的数量
        HashSet<Character> set = new HashSet<>();
        //用set的去重性质来装s中少于t的字符的数量。如果相等了的就移除。
        for (int i = 0;i<m;i++){
            if (tCnt[t.charAt(i)-'A'] > sCnt[t.charAt(i)-'A']){
                set.add(t.charAt(i));//不符合的情况。s中的字符少于t的字符（存的是t中的字符）
            }
        }

        int i = 0 , j = m-1;
        int min = Integer.MAX_VALUE;
        int l = 0 , r = -1;
        if (set.isEmpty()) {//如果s的前m个字符就符合了，那这个子串必是最短的。
            l = 0;
            r = m-1;
            min = m;//更新最短的长度
        }
        while (j<=n-1){
            j++;
            if (!set.isEmpty() && j <= n-1){//不满足能覆盖t的子串，右指针j就要往右去加字符。
                sCnt[s.charAt(j)-'A'] += 1;
                if (tCnt[s.charAt(j)-'A']!=0 && sCnt[s.charAt(j)-'A'] >= tCnt[s.charAt(j)-'A']){//判断是否是t里面的字符且是否满足数量了
                    set.remove(s.charAt(j));
                }
            }
            while (set.isEmpty() && i <= j && j<=n-1){//满足了，就缩小左边界i找是否还有更短的。
                if (j - i + 1 < min){//如果右更短的，更新。
                    min = j-i+1;
                    l = i;
                    r = j;
                }
                sCnt[s.charAt(i)-'A'] -= 1;
                if (tCnt[s.charAt(i)-'A']!=0 && sCnt[s.charAt(i)-'A'] < tCnt[s.charAt(i)-'A']){
                    set.add(s.charAt(i));//删了一个，就要判断这个字符删去了的话还满不满足。
                }
                i++;
            }
        }
        return s.substring(l,r+1);//左合右闭。
    }
}
