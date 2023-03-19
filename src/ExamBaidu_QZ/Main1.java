package ExamBaidu_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        int cnt = 0;
        for (int i = 0;i<s.length()-4;i++) {
            if (count(s.substring(i,i+5))) {
                cnt++;
            }
//            System.out.println(s.substring(i,i+5));
        }
        System.out.println(cnt);

    }

    public static boolean count(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        HashSet<Character> set1 = new HashSet<>();
        for (int i = 0;i<s.length();i++) {
            set1.add(s.charAt(i));
        }
//        System.out.println(set1.size());
        if (set1.size() == 5 && !set.contains(s.charAt(0)) && !set.contains(s.charAt(3)) && set.contains(s.charAt(1)) && set.contains(s.charAt(2)) && set.contains(s.charAt(4))) {

            return true;
        }
        return false;
    }
}
