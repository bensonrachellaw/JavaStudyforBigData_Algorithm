package ExamXC_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/30
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        String s = reader.nextLine();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1;i<=n;i++) {
            graph.put(i,new ArrayList<>());
        }
        int[][] arr = new int[n][2];
        for (int i = 1;i<=n-1;i++) {
            int X = reader.nextInt();
            int Y = reader.nextInt();
            arr[i][0] = X;
            arr[i][1] = Y;
            graph.get(X).add(Y);
            graph.get(Y).add(X);
        }
        int cnt = 0;
        for (int i = 1;i<=n-1;i++) {
            graph.get(arr[i][0]).remove((Integer)arr[i][1]);
            graph.get(arr[i][1]).remove((Integer)arr[i][0]);
            if (bfs(arr[i][0],graph,s) == 3 && bfs(arr[i][1],graph,s) == 3){
                cnt++;
            }
            graph.get(arr[i][0]).add(arr[i][1]);
            graph.get(arr[i][1]).add(arr[i][0]);
        }
        System.out.println(cnt);
    }
    public static int bfs(int key,HashMap<Integer, List<Integer>> graph,String s) {
        Deque<Integer> queue = new ArrayDeque<>();
        HashSet<Character> set = new HashSet<>();
        boolean[] vis = new boolean[s.length()+1];
        queue.addLast(key);
        while (!queue.isEmpty()) {
            int out = queue.pollFirst();
            vis[out] = true;
            set.add(s.charAt(out-1));
            for (int x : graph.get(out)) {
                if (!vis[x]) {
                    queue.add(x);
                }
            }
        }
        return set.size();
    }
}
