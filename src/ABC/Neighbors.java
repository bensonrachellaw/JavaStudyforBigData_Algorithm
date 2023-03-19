package ABC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/12/12
 * input:
 * 20 5
 * 19 20
 * 1 2
 * 2 3
 * 3 4
 * 1 4
 * 判断无向图是否存在环。包括建图 全局变量 dfs 退出程序 类 等等知识点 十分值得学习。
 */
public class Neighbors {

    public static HashMap<Integer,List<Integer>> graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        graph = new HashMap<>();
        visited = new boolean[n+1];

        for (int i = 1;i<=n;i++) {
            graph.put(i,new ArrayList<>());
        }
        for (int i = 0;i<m;i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1;i<=n;i++) {
            if (graph.get(i).size() > 2) {
                System.out.print("No");
                System.exit(0);
            }
        }

        for (int i = 1;i<=n;i++) {
            if (!visited[i]){
                if (dfs(i,0)){
                    System.out.print("No");
                    System.exit(0);
                }
            }
        }
        System.out.print("Yes");

    }
    static boolean dfs(int k,int p){
        visited[k] = true;
        for (int c : graph.get(k)) {
            if (c!=p){
                if (visited[c]){
                    return true;
                }
                dfs(c,k);
            }
        }
        return false;
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
