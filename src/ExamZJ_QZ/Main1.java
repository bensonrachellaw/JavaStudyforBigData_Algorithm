package ExamZJ_QZ;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String[] arr = new String[n];
        String x = reader.nextLine();
        for (int i = 0;i<n;i++) {
            arr[i] = reader.nextLine();
        }
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0;i<n;i++) {
            String tmp = arr[i];
            if (!re1(tmp)){
                System.out.println("yes");
                map.put(tmp,i);
                continue;
            }
            if (map.containsKey(tmp) && i - map.get(tmp) <= 10){
                System.out.println("yes");
                map.put(tmp,i);
                continue;
            }
            System.out.println("no");
            map.put(tmp,i);
        }
    }

    public static boolean re1(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('q');
        set.add('w');
        set.add('k');
        set.add('h');
        set.add('j');
        set.add('Q');
        set.add('W');
        set.add('K');
        set.add('J');
        set.add('H');
        for (int i = 0;i<s.length()-4;i++) {
            if (set.contains(s.charAt(i))){
                if (set.contains(s.charAt(i+1))&&set.contains(s.charAt(i+2))&&set.contains(s.charAt(i+3))&&set.contains(s.charAt(i+4))){
                    return false;
                }
            }
        }
        return true;
    }
}
//    String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
