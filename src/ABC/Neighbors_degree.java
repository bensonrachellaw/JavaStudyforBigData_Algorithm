package ABC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/12/13
 */
public class Neighbors_degree {
//    public static HashMap<Integer, List<Integer>> graph; is OK !List是一个接口，而ArrayList是List接口的一个实现类。
    public static HashMap<Integer, ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int[] degree;
    public static Deque<Integer> queue;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        graph = new HashMap<>();
        visited = new boolean[n+1];
        degree = new int[n+1];

        for (int i = 1;i<=n;i++) {
            graph.put(i,new ArrayList<>());
        }

        for (int i = 0;i<m;i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u] +=1;
            degree[v] +=1;
        }

        queue = new ArrayDeque<>();

        for (int i = 1;i<=n;i++) {
            if (degree[i] > 2) {
                System.out.print("No");
                System.exit(0);
            }
            if (degree[i]==1){
                queue.addLast(i);
            }
        }

        if (! DAG(n)){
            System.out.print("No");
            System.exit(0);
        }

        System.out.print("Yes");
    }


    static boolean DAG(int n){
        while (! queue.isEmpty()){
            int v = queue.pollFirst();
            for (int u : graph.get(v)){
                degree[u] -= 1;
                if (degree[u]==1){
                    queue.addLast(u);
                }
            }
        }
        int tag = 0;
        for (int i = 1;i<=n;i++){
            if (degree[i]==2){
                tag = 1;
                break;
            }
        }
        return tag != 1;
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
