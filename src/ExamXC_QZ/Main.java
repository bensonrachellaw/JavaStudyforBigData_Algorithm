package ExamXC_QZ;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            char[]color = scanner.next().toCharArray();
            int start = -1;
            int[]du = new int[n];
            HashMap<Integer,List<Integer>>edges = new HashMap<>();
            List<Integer>list;
            for (int i=1;i<n;i++){
                int u = scanner.nextInt()-1;
                int v = scanner.nextInt()-1;
                du[u]++;
                du[v]++;
                list = edges.getOrDefault(u,new LinkedList<>());
                list.add(v);
                edges.put(u,list);
                list = edges.getOrDefault(v,new LinkedList<>());
                list.add(u);
                edges.put(v,list);
            }
            for (int i=0;i<n;i++){
                if (du[i]==1){
                    start = i;
                    break;
                }
            }
            int [][]left = new int[n][3],right = new int[n+1][3];
            int pre = -1,next=-1;
            list = edges.get(start);
            int index = 1;
            do{
                System.arraycopy(left[index - 1], 0, left[index], 0, 3);
                if (color[start]=='r'){
                    left[index][0]++;
                }else if (color[start]=='g'){
                    left[index][1]++;
                }else {
                    left[index][2]++;
                }
                index++;
                for (int e:list){
                    if (pre==e)continue;
                    next = e;
                }
                pre = start;
                start = next;
                list = edges.get(start);
            }while (list.size()>1);
            pre = -1;
            next=-1;
            list = edges.get(start);
            index = n-1;
            do{
                System.arraycopy(right[index+1], 0, right[index], 0, 3);
                if (color[start]=='r'){
                    right[index][0]++;
                }else if (color[start]=='g'){
                    right[index][1]++;
                }else {
                    right[index][2]++;
                }
                index--;
                for (int e:list){
                    if (pre==e)continue;
                    next = e;
                }
                pre = start;
                start = next;
                list = edges.get(start);
            }while (list.size()>1);
            int ans = 0;
            for (int i=0;i<n;i++){
                boolean flag = true;
                for (int j=0;j<3;j++){
                    if (left[i][j]<1||right[i][j]<1){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    ans ++;
                }

            }
            System.out.println(ans);


        }
    }
}

