package ExamXHS_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/28
 *
 * 题目描述：
 * 某公司正在组织新员工团建，其中一项活动是两两配对进行石头剪刀布。
 * 因为新员工来自不同的学校和专业，他们许多人之间并不熟悉，但他们之间的朋友关系形成了一棵树。
 * 即若将朋友关系描述为一张无向图，则这张无向图中任意两点之间有且仅有一条路径。为了避免尴尬，组织者希望互为朋友的配对数量尽可能多。
 * 现在他希望你求出互为朋友的配对数量最多能有多少。
 *
 * 输入描述
 * 第一行有一个偶数n(2 <= n <= 1000)，代表有n个新员工。
 * 第二行有n - 1个空格隔开的数，第i个数ai代表编号为i + 1的新员工与编号为ai的员工互为朋友。
 * 输入保证新员工之间的朋友关系形成了一棵树
 *
 * 输出描述
 * 输出在所有可能的配对方案中，互为朋友的配对数量最多是多少。
 *
 * 样例输入
 * 6
 * 1 2 2 3 3
 * 样例输出
 * 2
 *
 * 提示:
 * 如样例中，一共有6个新员工，朋友关系有以下五个(1, 2), (2, 3), (2, 4), (3, 5), (3, 6)。
 * 可以证明无论如何匹配这6个人， 最多只能有两对是互为朋友的，因此输出2。
 *
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n+1];
        for (int i = 1;i<=n-1;i++) {
            int t = reader.nextInt();
            if (!graph.containsKey(t)) {
                graph.put(t,new ArrayList<>());
            }
            if (!graph.containsKey(i+1)) {
                graph.put(i+1,new ArrayList<>());
            }
            graph.get(t).add(i+1);
            graph.get(i+1).add(t);
            degree[t]++;
            degree[i+1]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1;i<=n-1;i++) {
            if (degree[i]==1) {
                queue.addLast(i);
            }
        }
        int ans = 0;
        boolean[] vis = new boolean[n+1];
        while (!queue.isEmpty()) {
            int out = queue.pollFirst();
            if (!vis[out]) {

                vis[out] = true;
                for (int x : graph.get(out)) {
                    if (!vis[x]) {
                        vis[x] = true;
                        ans++;
                        for (int y : graph.get(x)) {
                            degree[y]--;
                            if (degree[y]==1) queue.addLast(y);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

/**
 * int[] arr = new int[n+1];
 *         for (int i = 1;i<n;i++) {
 *             arr[i] = reader.nextInt();
 *         }
 *         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
 *         int[] in_cnt = new int[n+1];
 *         for(int i = 0 ; i<n+1 ; i++){
 *             adj.add(new ArrayList<>());
 *         }
 *         int ans = 0;
 * //        for (int i = 1;i<=n;i++) {
 * //            adj.get(arr[i]).add(i+1);
 * //            adj.get(i+1).add(arr[i]);
 * //            in_cnt[arr[i]]++;
 * //            in_cnt[i+1]++;
 * //        }
 *         int[] in_cnt1 = new int[n];
 * //        for (int i = 1;i<=n;i++) {
 * //
 * //            in_cnt1[arr[i]-1]++;
 * //            in_cnt1[i]++;
 * //        }
 *         Arrays.sort(in_cnt1);
 *         int[] v = new int[n];
 *         for (int i = 0;i<n;i++){
 *             if (v[i]==0) {
 *                 if (v[arr[i+1]-1]==0) {
 *                     v[arr[i+1]-1]=1;
 *                     v[i] = 1;
 *                     ans++;
 *                 }
 *             }
 *         }
 *         System.out.println(ans);
 *
 */
