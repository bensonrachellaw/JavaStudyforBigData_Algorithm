package ExamXC_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/30
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = reader.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<n-1;i++) {
            int cc = Math.abs(arr[i] - arr[i+1]);
            map.put(cc,map.getOrDefault(cc,0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());//降序
            }
        });
        int ans = 0;
        if (list1.get(0).getValue()==1) {
            ans = list1.get(1).getKey();
        }
        else {
            ans = list1.get(0).getKey();
        }
        System.out.println(ans);
    }
}
