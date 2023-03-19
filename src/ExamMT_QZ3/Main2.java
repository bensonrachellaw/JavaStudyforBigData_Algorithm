package ExamMT_QZ3;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[][] dw = new int[3][2];
        int[] loc = new int[3];
        for (int i = 0;i<3;i++) {
            dw[i][0] = reader.nextInt();
            dw[i][1] = reader.nextInt();
        }
        for (int i = 0;i<3;i++) {
            loc[i] = reader.nextInt();
        }
        HashMap<List<Integer>,Integer> map1 = new HashMap<>();

        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=n;j++) {
                if (Math.abs(dw[0][0]-i)+Math.abs(dw[0][1]-j) == loc[0]) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    map1.put(l,0);
                }
            }
        }
        HashMap<List<Integer>,Integer> map2 = new HashMap<>();
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=n;j++) {
                if (Math.abs(dw[1][0]-i)+Math.abs(dw[1][1]-j) == loc[1]) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    map2.put(l,0);
                }
            }
        }
        HashMap<List<Integer>,Integer> map3 = new HashMap<>();
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=n;j++) {
                if (Math.abs(dw[2][0]-i)+Math.abs(dw[2][1]-j) == loc[2]) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    map3.put(l,0);
                }
            }
        }
        ArrayList<Map.Entry<List<Integer>,Integer>> list1 = new ArrayList<>(map1.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<List<Integer>,Integer>>() {
            @Override
            public int compare(Map.Entry<List<Integer>,Integer> o1, Map.Entry<List<Integer>,Integer> o2) {
                if (o2.getKey().get(0).compareTo(o1.getKey().get(0))!=0){
                    return o1.getKey().get(0).compareTo(o2.getKey().get(0));
                }
                else {
                    return o1.getKey().get(1).compareTo(o2.getKey().get(1));
                }

            }
        });
        for (int i = 0;i<list1.size();i++) {
            if (map2.containsKey(list1.get(i).getKey()) && map3.containsKey(list1.get(i).getKey())) {
                System.out.println(list1.get(i).getKey().get(0) + " " + list1.get(i).getKey().get(1));
                break;
            }
        }
    }
}