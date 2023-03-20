package ExamQNR_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/7
 * 德州扑克，同花顺，模拟全部情况
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println();
    }
    public String showDown (String inHand) {
        // write code here
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        map.put('S',new HashSet<>());
        map.put('H',new HashSet<>());
        map.put('D',new HashSet<>());
        map.put('C',new HashSet<>());
        map.put('B',new HashSet<>());

//        HashSet<Character> set1 = new HashSet<>();
        String[] s = inHand.split(" ");
        for (int i = 0;i<s.length;i++) {
            map.get(s[i].charAt(0)).add(s[i].charAt(1));
            map.get('B').add(s[i].charAt(1));
        }
        char[] all = {'A','K','Q','J','1','2','3','4','5','6','7','8','9'};
        for (char item : map.keySet()) {
            if (item=='B') continue;
            if (map.get(item).size() >= 5) {
                if (map.get(item).contains('A') && map.get(item).contains('K')&& map.get(item).contains('Q')&& map.get(item).contains('J')&& map.get(item).contains('1')){
                    return "HuangJiaTongHuaShun";
                }
            }
        }

        for (char item : map.keySet()) {
            if (item=='B') continue;
            if (map.get(item).size() >= 5) {
                if (map.get(item).contains('K') && map.get(item).contains('Q')&& map.get(item).contains('J')&& map.get(item).contains('1')&& map.get(item).contains('9')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('Q') && map.get(item).contains('J')&& map.get(item).contains('1')&& map.get(item).contains('8')&& map.get(item).contains('8')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('J') && map.get(item).contains('1')&& map.get(item).contains('9')&& map.get(item).contains('8')&& map.get(item).contains('7')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('1') && map.get(item).contains('9')&& map.get(item).contains('8')&& map.get(item).contains('7')&& map.get(item).contains('6')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('9') && map.get(item).contains('8')&& map.get(item).contains('7')&& map.get(item).contains('6')&& map.get(item).contains('5')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('8') && map.get(item).contains('7')&& map.get(item).contains('6')&& map.get(item).contains('5')&& map.get(item).contains('4')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('7') && map.get(item).contains('6')&& map.get(item).contains('5')&& map.get(item).contains('4')&& map.get(item).contains('3')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('6') && map.get(item).contains('5')&& map.get(item).contains('4')&& map.get(item).contains('3')&& map.get(item).contains('2')){
                    return "TongHuaShun";
                }
                if (map.get(item).contains('5') && map.get(item).contains('4')&& map.get(item).contains('3')&& map.get(item).contains('2')&& map.get(item).contains('A')){
                    return "TongHuaShun";
                }
            }
        }

        for (char item : all){
            int cnt = 0;
            for (char item1 : map.keySet()) {
                if (item1=='B') continue;
                if (map.get(item1).contains(item)) {
                    cnt++;
                }
            }
            if (cnt>=4) {
                return "SiTiao";
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (char item : all){
            int cnt = 0;
            for (char item1 : map.keySet()) {
                if (item1=='B') continue;
                if (map.get(item1).contains(item)) {
                    cnt++;
                }
            }
            set.add(cnt);
            if (set.contains(3)&&set.contains(2)) {
                return "HuLu";
            }
        }
        for (char item : map.keySet()) {
            if (item=='B') continue;
            if (map.get(item).size() >= 5) {
                return "TongHua";
            }
        }

        char item = 'B';
        if (map.get(item).contains('K') && map.get(item).contains('Q')&& map.get(item).contains('J')&& map.get(item).contains('1')&& map.get(item).contains('9')){
            return "ShunZi";
        }
        if (map.get(item).contains('Q') && map.get(item).contains('J')&& map.get(item).contains('1')&& map.get(item).contains('8')&& map.get(item).contains('8')){
            return "ShunZi";
        }
        if (map.get(item).contains('J') && map.get(item).contains('1')&& map.get(item).contains('9')&& map.get(item).contains('8')&& map.get(item).contains('7')){
            return "ShunZi";
        }
        if (map.get(item).contains('1') && map.get(item).contains('9')&& map.get(item).contains('8')&& map.get(item).contains('7')&& map.get(item).contains('6')){
            return "ShunZi";
        }
        if (map.get(item).contains('9') && map.get(item).contains('8')&& map.get(item).contains('7')&& map.get(item).contains('6')&& map.get(item).contains('5')){
            return "ShunZi";
        }
        if (map.get(item).contains('8') && map.get(item).contains('7')&& map.get(item).contains('6')&& map.get(item).contains('5')&& map.get(item).contains('4')){
            return "ShunZi";
        }
        if (map.get(item).contains('7') && map.get(item).contains('6')&& map.get(item).contains('5')&& map.get(item).contains('4')&& map.get(item).contains('3')){
            return "ShunZi";
        }
        if (map.get(item).contains('6') && map.get(item).contains('5')&& map.get(item).contains('4')&& map.get(item).contains('3')&& map.get(item).contains('2')){
            return "ShunZi";
        }
        if (map.get(item).contains('5') && map.get(item).contains('4')&& map.get(item).contains('3')&& map.get(item).contains('2')&& map.get(item).contains('A')){
            return "ShunZi";
        }

        for (char item2 : all){
            int cnt = 0;
            for (char item1 : map.keySet()) {
                if (item1=='B') continue;
                if (map.get(item1).contains(item2)) {
                    cnt++;
                }
            }
            if (cnt>=3) {
                return "SanTiao";
            }
        }
        int tag =0;
        for (char item2 : all){
            int cnt = 0;
            for (char item1 : map.keySet()) {
                if (item1=='B') continue;
                if (map.get(item1).contains(item2)) {
                    cnt++;
                }
            }
            if (cnt>=2) {
                tag++;
            }
            if (tag>=2) {
                return "LiangDui";
            }
        }



        return "YiDui";
    }
}
