package ExamHW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] arr = reader.nextLine().split(" ");
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        map.put('a','A');
        map.put('e','E');
        map.put('i','I');
        map.put('o','O');
        map.put('u','U');
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i  = 0;i< arr.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<arr[i].length();j++){
                if (set.contains(arr[i].charAt(j)) && map.containsKey(arr[i].charAt(j))){
                    sb.append(map.get(arr[i].charAt(j)));
                }
                else if (!set.contains(arr[i].charAt(j)) && arr[i].charAt(j) <97 ){
                    char c = (char) (arr[i].charAt(j)+32);
                    sb.append(c);
                }
                else {
                    char c = (char) (arr[i].charAt(j));
                    sb.append(c);
                }
            }
            if (i==arr.length-1) {//以空格分隔输出
                System.out.print(sb.toString());
            }
            else{
                System.out.print(sb.toString()+" ");
            }
        }
    }
}
