package ExamZJ_QZ;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();
        HashMap<String,HashMap<String,Integer>> map = new HashMap<>();
        for (int i = 0;i<n;i++) {
            String s = reader.nextLine();
            String[] a = s.split(" ");
            String[] ss = a[1].split(":");
            String[] ee = a[2].split(":");
            int temp = 0;
            if (Objects.equals(ss[0], ee[0])) {
                temp +=  (Integer.parseInt(ee[1])-Integer.parseInt(ss[1]))*60  + Integer.parseInt(ee[2]) - Integer.parseInt(ss[2]);

                HashMap<String ,Integer> mapx = new HashMap<>();
                mapx.put(a[0],temp);
                map.put(ee[0],mapx);
            }
            else {
                temp += (60-Integer.parseInt(ss[1]))*60 + (Integer.parseInt(ee[1]))*60 + (Integer.parseInt(ee[2])) -(Integer.parseInt(ss[2]));
                HashMap<String ,Integer> mapx = new HashMap<>();
                mapx.put(a[0],temp);
                map.put(ee[0],mapx);
            }
        }
    }
}
