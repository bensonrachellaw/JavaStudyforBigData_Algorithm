package ExamWY;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        for (int i = 0;i<n;i++) {
            HashMap<String,List<Integer>> map = new HashMap<>();
            for (int j = 0;j<6;j++) {
                String[] s = reader.nextLine().split(" ");
                List<Integer> listx = new ArrayList<>();
                listx.add(Integer.parseInt(s[1]));//积分
                listx.add(Integer.parseInt(s[2]));
                listx.add(Integer.parseInt(s[3]));
                listx.add(Integer.parseInt(s[2])-Integer.parseInt(s[3]));
                map.put(s[0],listx);
            }
            for (int j = 6;j<9;j++) {
                String[] ss = reader.nextLine().split(" ");
                if (Integer.parseInt(ss[2])-Integer.parseInt(ss[3])>0){
                    int jifen = map.get(ss[0]).get(0) + 3;
                    int jinqiu = map.get(ss[0]).get(1) + Integer.parseInt(ss[2]);
                    int shiqiu = map.get(ss[0]).get(2) + Integer.parseInt(ss[3]);
                    int js = jinqiu - shiqiu;
                    List<Integer> list = new ArrayList<>();
                    list.add(jifen);//积分
                    list.add(jinqiu);
                    list.add(shiqiu);
                    list.add(js);
                    map.put(ss[0],list);
                    int jifen1 = map.get(ss[1]).get(0);
                    int jinqiu1 = map.get(ss[1]).get(1) + Integer.parseInt(ss[3]);
                    int shiqiu1 = map.get(ss[1]).get(2) + Integer.parseInt(ss[2]);
                    int js1 = jinqiu1 - shiqiu1;
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(jifen1);//积分
                    list1.add(jinqiu1);
                    list1.add(shiqiu1);
                    list1.add(js1);
                    map.put(ss[1],list1);
                }
                else if (Integer.parseInt(ss[2])-Integer.parseInt(ss[3])<0){
                    int jifen = map.get(ss[0]).get(0);
                    int jinqiu = map.get(ss[0]).get(1) + Integer.parseInt(ss[2]);
                    int shiqiu = map.get(ss[0]).get(2) + Integer.parseInt(ss[3]);
                    int js = jinqiu - shiqiu;
                    List<Integer> list = new ArrayList<>();
                    list.add(jifen);//积分
                    list.add(jinqiu);
                    list.add(shiqiu);
                    list.add(js);
                    map.put(ss[0],list);
                    int jifen1 = map.get(ss[1]).get(0) + 3;
                    int jinqiu1 = map.get(ss[1]).get(1) + Integer.parseInt(ss[3]);
                    int shiqiu1 = map.get(ss[1]).get(2) + Integer.parseInt(ss[2]);
                    int js1 = jinqiu1 - shiqiu1;
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(jifen1);//积分
                    list1.add(jinqiu1);
                    list1.add(shiqiu1);
                    list1.add(js1);
                    map.put(ss[1],list1);
                }
                else {
                    int jifen = map.get(ss[0]).get(0) + 1;
                    int jinqiu = map.get(ss[0]).get(1) + Integer.parseInt(ss[2]);
                    int shiqiu = map.get(ss[0]).get(2) + Integer.parseInt(ss[3]);
                    int js = jinqiu - shiqiu;
                    List<Integer> list = new ArrayList<>();
                    list.add(jifen);//积分
                    list.add(jinqiu);
                    list.add(shiqiu);
                    list.add(js);
                    map.put(ss[0],list);
                    int jifen1 = map.get(ss[1]).get(0) + 1;
                    int jinqiu1 = map.get(ss[1]).get(1) + Integer.parseInt(ss[3]);
                    int shiqiu1 = map.get(ss[1]).get(2) + Integer.parseInt(ss[2]);
                    int js1 = jinqiu1 - shiqiu1;
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(jifen1);//积分
                    list1.add(jinqiu1);
                    list1.add(shiqiu1);
                    list1.add(js1);
                    map.put(ss[1],list1);
                }
            }
            List<Map.Entry<String,List<Integer>>> ansList = re(map);
            for (int ii = 0;ii<7;ii++){
                if (ii==6){
                    System.out.println("END");
                }
                else {
                    System.out.println(ansList.get(ii).getKey()+" "+ansList.get(ii).getValue().get(0)+" "+ansList.get(ii).getValue().get(1)+" "+ansList.get(ii).getValue().get(2));
                }
            }
        }
    }
    public static List<Map.Entry<String,List<Integer>>> re(HashMap<String,List<Integer>> map){
        ArrayList<Map.Entry<String,List<Integer>>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String,List<Integer>>>() {
            @Override
            public int compare(Map.Entry<String,List<Integer>> o1, Map.Entry<String,List<Integer>> o2) {
                if (o2.getValue().get(0).compareTo(o1.getValue().get(0))!=0){
                    return o2.getValue().get(0).compareTo(o1.getValue().get(0));
                }
                else if (o2.getValue().get(3).compareTo(o1.getValue().get(3))!=0){
                    return o2.getValue().get(3).compareTo(o1.getValue().get(3));
                }
                else if (o2.getValue().get(1).compareTo(o1.getValue().get(1))!=0){
                    return o2.getValue().get(1).compareTo(o1.getValue().get(1));
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }

            }
        });
        return list1;
    }
}
