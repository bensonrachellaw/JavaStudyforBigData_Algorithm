package ExamHW;

import java.util.*;

public class Main2 {
    //拓扑排序
    public static HashSet<Integer> set;
    public static int tag = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int M = reader.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0;i<N;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int num = reader.nextInt();
            for (int j = 0;j<num;j++){
                arr.add(reader.nextInt());
            }
            list.add(arr);
        }
        if (list.get(M).isEmpty()) System.out.println("null");
        if (M>=N) System.out.println(-1);

        dfs(M,list);
        if (tag==1) System.out.println(-1);
        set.remove(M);
        ArrayList<Integer> list1 = new ArrayList<>(set);
        Collections.sort(list1);
        for (int i = 0;i<set.size();i++){
            if (i==set.size()-1){
                System.out.print(list1.get(i));
            }
            else {
                System.out.print(list1.get(i)+",");
            }

        }
    }
    //未剪枝有错误的，请参考课程表二
    public static void dfs(int k,ArrayList<ArrayList<Integer>> list){
        if (set.contains(k)) {
            tag =1;
            return;
        }
        set.add(k);
        for (int x :list.get(k)){
            dfs(x,list);
        }
    }
}
