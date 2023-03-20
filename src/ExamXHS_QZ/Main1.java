package ExamXHS_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int id = reader.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 1;i<=n;i++) {
            int temp = 0;
            for (int j = 1;j<=m;j++) {
                temp += reader.nextInt();
            }
            map.put(i,temp);
        }
        ArrayList<Map.Entry<Integer,Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue())!=0){
                    return o2.getValue().compareTo(o1.getValue());
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }

            }
        });
        int ans = 0;
        for (int i = 0;i<list1.size();i++) {
            if (list1.get(i).getKey()==id) {
                ans = i+1;
            }
        }
        System.out.println(ans);
    }
}
