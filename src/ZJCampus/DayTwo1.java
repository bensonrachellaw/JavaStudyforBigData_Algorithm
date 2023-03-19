package ZJCampus;

import java.util.HashSet;

public class DayTwo1 {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String[] strs) {
        int min = 201;
        for(String s : strs){
            int l = s.length();
            min = Math.min(l,min);
        }
        StringBuilder ans = new StringBuilder("");
        HashSet<Character> set = new HashSet<>();
        for (int i = 0;i<min;i++){
            for (String s : strs){
                set.add(s.charAt(i));
            }
            if (set.size()==1){
                ans.append(set.iterator().next());
                set.clear();
            }
            else{
                return ans.toString();
            }
        }
        return ans.toString();
    }

    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
