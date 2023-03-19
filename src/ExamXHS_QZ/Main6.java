package ExamXHS_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/25
 * 迪杰斯特拉(Dijkstra)算法是寻找从一个顶点到其余各顶点的最短路径算法，可用来解决最短路径问题。（单源）
 * Floyd–Warshall algorithm. Floyd-Warshall 算法用来找出每对点之间的最短距离。（多源）
 * 本题是多源的，且不需要图中路径长度必须大于等于 0
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]dis =new int[n+1][n+1];
        int[]t = new int[n+1];
        for (int i=2;i<=n;i++){
            t[i] = sc.nextInt();
        }
        for (int i=0;i<=n;i++){//初始化都为不可达
            Arrays.fill(dis[i],(int)1e9);
            dis[i][i] = 0;//自己到达自己是可达的。所以不需要任何距离
        }
        for (int i=2;i<=n;i++){
            dis[i][t[i]] = sc.nextInt();
            dis[t[i]][i] = dis[i][t[i]];
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //计算每两个节点之间的最短距离。
        for (int k=1;k<=n;k++){//每次加入一个中间节点k，然后遍历所有节点间的距离，更新最小值。

            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);//更新最小值。算法思想：每次加一个k进去，看看所有的点之间的距离是否变短，变短就更新，否则就是加了等于没加，直接等于原来的值。
                }
            }

        }
        int ans = (int) 1e9;
        for (int i=1;i<n;i++){//再找出一个离a，b，c距离之和最短的节点。
            ans = Math.min(ans,dis[i][a]+dis[i][b]+dis[i][c]);
        }
        System.out.println(ans);

    }
}