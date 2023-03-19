package ExamALI;

import java.math.BigInteger;
import java.util.*;

public class Main1 {
    //进制转换，问给一个数字，有多少种可能的表示进制（2-16），然后输出这些进制的十进制表示并取模，然后排列，并去重。
    //剑指 Offer 14- II. 剪绳子 II 快速幂但是要求余
    //第一题是SQL题：涉及select中的嵌套（select （select ……））、concat字符串拼接、保留小数。https://blog.csdn.net/reee112/article/details/83544605
    public static void main(String[] args) {
        long m = 1000000007;
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        int max = 0;
        //比s中最大的数都要大的才有可能成为进制表示。
        for (char c :s.toCharArray()){
            if (map.containsKey(c)){
                max = Math.max(max,map.get(c));
            }
            else {
                max = Math.max(max,(int)(c-'0'));
            }
        }
        HashSet<Long> set = new HashSet<>();
        for (int i = max+1;i<=16;i++){
            long x = 1;
            long ans = 0;
            for (int j = s.length()-1;j>=0;j--){
                if (map.containsKey(s.charAt(j))){
                    int tmp = map.get(s.charAt(j));
                    ans += tmp * x;
                    ans %= m;
                }
                else {
                    ans += (long)(s.charAt(j)-'0') * x;
                    ans %= m;
                }
                x *= i;
                x %= m;//必须求余
            }
            set.add(ans%m);
        }
        ArrayList<Long> list1 = new ArrayList<>(set);
        Collections.sort(list1);
        for (int i = 0;i<list1.size();i++){
            System.out.println(list1.get(i));
        }
    }
}
