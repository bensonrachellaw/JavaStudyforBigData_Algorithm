package ZJCampus;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DayEight1 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                list.addLast(s.charAt(i));
            }
            if (s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                if (list.peekLast()==null){
                    return false;
                }
                else {
                    char temp = list.pollLast();
                    if (s.charAt(i) != map.get(temp)){
                        return false;
                    }
                }
            }

        }
        if (list.isEmpty()){
            return true;
        }
        else {
            return false;
        }

    }
}
