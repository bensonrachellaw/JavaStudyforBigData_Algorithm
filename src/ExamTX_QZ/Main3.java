package ExamTX_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/10/16
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<n;i++) {
            arr[i] = reader.nextInt();
            map.put(i,solution(Integer.toBinaryString(arr[i])));
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        priorityQueue.addAll(map.entrySet());
        while (k>0){
            Map.Entry<Integer, Integer> m = priorityQueue.poll();
            arr[m.getKey()] = m.getValue();
            HashMap<Integer,Integer> map1 = new HashMap<>();
            map1.put(m.getKey(),solution(Integer.toBinaryString(m.getValue())));
            priorityQueue.addAll(map1.entrySet());
            k--;
        }
        int cnt = 0;
        for (int i = 0;i<n;i++) {
            cnt += arr[i];
        }
        System.out.println(cnt);
    }
    private static int solution(String s){
        int cnt = 0;
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i)=='1') {
                cnt++;
            }
        }
        return cnt;
    }
}
