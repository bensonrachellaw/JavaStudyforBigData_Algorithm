package JZoffers;

import java.util.*;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/10
 * LC17《电话号码的字母组合》
 */
//LC17《电话号码的字母组合》：循环DFS+回溯+HashMap
public class LC17 {
    public static List<String> list = new ArrayList<>();
    public static HashMap<Character,ArrayList<Character>> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n==0) return new ArrayList<>();
        map.put('2',new ArrayList<>(Arrays.asList('a', 'b', 'c')));//Java中ArrayList初始化的方法之一：Arrays.asList
        map.put('3',new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4',new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5',new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6',new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7',new ArrayList<>(Arrays.asList('p', 'q', 'r','s')));
        map.put('8',new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9',new ArrayList<>(Arrays.asList('w', 'x', 'y','z')));
        StringBuilder s = new StringBuilder("");
        dfs(0,s,digits);
        return list;
    }
    public static void dfs(int cnt,StringBuilder s,String digits){
        if (cnt==digits.length()){
            list.add(s.toString());
            return;
        }
        for (char c : map.get(digits.charAt(cnt))){
            s.append(c);
            dfs(cnt+1,s,digits);
            s.deleteCharAt(cnt);
        }
    }
}
