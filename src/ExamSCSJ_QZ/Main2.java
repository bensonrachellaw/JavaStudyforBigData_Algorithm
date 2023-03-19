package ExamSCSJ_QZ;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        HashMap<Long,Long> map = new HashMap<>();
        for (int i = 0;i<n;i++) {
            long a = reader.nextLong();
            long b = reader.nextLong();
            map.put(a,b);
        }
        long c1 = reader.nextLong();
        long c2 = reader.nextLong();

        long x = c1,y = c2;
        ArrayList<Long> l = new ArrayList<>();
        l.add(x);
        while (x!=1) {

            x = map.get(x);
            l.add(x);
        }
        HashSet<Long> set = new HashSet<>();
        set.add(y);
        while (y!=1) {

            y = map.get(y);
            set.add(y);
        }
        long ans = 0;
        for (long i:l){
            if (set.contains(i)){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
