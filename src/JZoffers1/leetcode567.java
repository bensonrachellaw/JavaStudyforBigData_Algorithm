package JZoffers1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2022/2/21
 */
//字节笔试第二题
public class leetcode567 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s1 = reader.next();
        String s2 = reader.next();
        if (checkInclusion(s1,s2)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    //比较两个数组是否相等用Arrays.equals。做法简单很多
    //使用两个数组来作记录
    static public boolean checkInclusion_1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkInclusion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }

        HashSet<Character> set = new HashSet<Character>();

        int[] s1_line = new int[30];
        int[] s2_line = new int[30];

        for(int i = 0 ; i < n ; i++){
            s1_line[s1.charAt(i)-'a']++;
            s2_line[s2.charAt(i)-'a']++;//会滑动 动态变化。
        }

        for(char i :s1.toCharArray()){
            if(s1_line[i-'a'] != s2_line[i-'a']){
                set.add(i);
            }
        }

        for(char i : Arrays.copyOf(s2.toCharArray(),n)){
            if(s2_line[i-'a'] != s1_line[i-'a']){
                set.add(i);
            }
        }

        if(set.isEmpty()){
            return true;
        }

        for(int i = 1 ; i <= m-n ; i++){
            int j = i + n - 1;
            s2_line[s2.charAt(i-1)-'a']--;
            s2_line[s2.charAt(j)-'a']++;

            if(s2.charAt(i-1) != s2.charAt(j)){
                if(s2_line[s2.charAt(i-1)-'a'] == s1_line[s2.charAt(i-1)-'a']){
                    set.remove(s2.charAt(i-1));
                }
                if(s2_line[s2.charAt(i-1)-'a'] != s1_line[s2.charAt(i-1)-'a']){
                    set.add(s2.charAt(i-1));
                }
                if(s2_line[s2.charAt(j)-'a'] != s1_line[s2.charAt(j)-'a']){
                    set.add(s2.charAt(j));
                }
                if(s2_line[s2.charAt(j)-'a'] == s1_line[s2.charAt(j)-'a']){
                    set.remove(s2.charAt(j));
                }
            }

            if(set.isEmpty()){
                return true;
            }


        }
        return false;
    }


}
