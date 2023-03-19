package ExamHW;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        HashMap<String,Integer> map3 = new HashMap<>();
        HashMap<String,Integer> map5 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int N = reader.nextInt();
        int M = reader.nextInt();
        String x = reader.nextLine();
        for (int i = 0;i<M*2;i++){
            String[] arr = reader.nextLine().split(" ");
            for (int j = 0;j<arr.length;j++){
                set.add(arr[j]);
                int pl = 0;
                if (i%2==0){
                    pl = 3;
                    if (!map1.containsKey(arr[j])){
                        map1.put(arr[j],pl);
                    }
                    else {
                        int tmp = map1.get(arr[j]);
                        tmp += pl;
                        map1.remove(arr[j]);
                        map1.put(arr[j],tmp);
                    }
                    if (!map3.containsKey(arr[j])){
                        map3.put(arr[j],j);
                    }
                    else {
                        int tmp = map3.get(arr[j]);
                        if (tmp>j){

                            map3.remove(arr[j]);
                            map3.put(arr[j],j);
                        }
                    }
                }
                if (i%2==1){
                    pl = 1;
                    if (!map2.containsKey(arr[j])){
                        map2.put(arr[j],pl);
                    }
                    else {
                        int tmp = map2.get(arr[j]);
                        tmp += pl;
                        map2.remove(arr[j]);
                        map2.put(arr[j],tmp);
                    }
                    if (!map5.containsKey(arr[j])){
                        map5.put(arr[j],j);
                    }
                    else {
                        int tmp = map5.get(arr[j]);
                        if (tmp>j){
                            map5.remove(arr[j]);
                            map5.put(arr[j],j);
                        }
                    }
                }
            }
        }
        HashMap<String, List<Integer>> map4 = new HashMap<>();
        for (String t : set){
            int a = 0;
            int b = 0;
            int c = 0;
            if (map1.containsKey(t)){
                a += map1.get(t);
            }
            if (map2.containsKey(t)){
                b += map2.get(t);
            }
            c = a+b;
            List<Integer> list = new ArrayList<>();
            list.add(c);
            list.add(a);
            if (map3.containsKey(t)){
                list.add(map3.get(t));
            }
            else {
                list.add(5005);
            }
            if (map5.containsKey(t)){
                list.add(map5.get(t));
            }
            else {
                list.add(5005);
            }
            map4.put(t,list);
        }
        ArrayList<Map.Entry<String,List<Integer>>> list1 = new ArrayList<>(map4.entrySet());

        Collections.sort(list1, new Comparator<Map.Entry<String,List<Integer>>>() {
            @Override
            public int compare(Map.Entry<String,List<Integer>> o1, Map.Entry<String,List<Integer>> o2) {
                if (o2.getValue().get(0).compareTo(o1.getValue().get(0))!=0){
                    return o2.getValue().get(0).compareTo(o1.getValue().get(0));
                }
                else if (o2.getValue().get(1).compareTo(o1.getValue().get(1))!=0){
                    return o2.getValue().get(1).compareTo(o1.getValue().get(1));
                }
                else if (o2.getValue().get(2).compareTo(o1.getValue().get(2))!=0){
                    return o1.getValue().get(2).compareTo(o2.getValue().get(2));
                }
                else {
                    return o1.getValue().get(3).compareTo(o2.getValue().get(3));
                }

            }
        });
        for (int i = 0;i<N;i++){
            if (i==N-1){
                System.out.print(list1.get(i).getKey());
            }
            else {
                System.out.print(list1.get(i).getKey()+" ");
            }
        }
    }
}
