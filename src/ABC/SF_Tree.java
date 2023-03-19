package ABC;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/31
 *
 * CF链接：https://codeforces.com/problemset/problem/274/B
 * 每次选包含1节点的一棵子树，将该子树所有值都+1或者-1最少多少步可以使树值全部为0 ：树型dp
 *
 * 有一棵圣诞树，圣诞树由n个节点组成（一棵树是一个有n个节点与正好n-1条边的图），每个节点上都有一些愿望（整数，可能为负数，即圣诞树回馈小红一个愿望）。节点从1到n编号。
 * 小红想要实现树上的所有愿望。她可以做一些操作，每次操作可以选择一个包含节点1的子图，并将子图的所有节点的愿望数量+1或-1（实现或回馈）。
 * 请问小红至少要操作多少次，才能让所有节点的愿望为0。（子图是指有一个图，它的节点和边都是原树的子集。）
 *
 * 每次选的时候一定要包含节点1，但是子树的大小不定，具体意思就是说选择了一个点，从这个点往上直到根节点1的经过的点都要同时加1/-1；
 * 儿子节点一定不会晚于父亲节点变成0,因为儿子要变，父亲节点肯定得变，但是父亲节点变，儿子节点可以不用变，因此从叶子节点开始往上进行DP。
 */
public class SF_Tree {
    public static int[] father;
    public static long[] gift;//每个节点的礼物数
    public static HashMap<Integer, ArrayList<Integer>> graph;//这个树的邻接表，是一个无向无环图

    public static long[] dpUP;//第i个节点变为0所需要的最少加一操作次数；
    public static long[] dpDOWN;//第i个节点变为0所需要的最少减一操作次数，两者之和表示：以i为根节点的子树全部节点变为0最少需要进行操作总数；
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        father = new int[n+1];
        gift = new long[n+1];
        graph = new HashMap<>();
        dpUP = new long[n+1];
        dpDOWN = new long[n+1];

        for (int i = 1;i<=n;i++) {
            graph.put(i,new ArrayList<>());
        }
        //建图
        for (int i = 2;i<=n;i++) {
            int temp1 = reader.nextInt();
            int temp2 = reader.nextInt();

            graph.get(temp1).add(temp2);
            graph.get(temp2).add(temp1);
        }
        for (int i = 1;i<=n;i++) {
            gift[i] = reader.nextLong();
        }
        //从节点1开始dfs遍历每个节点
        dfsDP(1,0);
        System.out.println(dpUP[1]+dpDOWN[1]);//以节点1为根节点的子树全部节点（也就是全树的节点）变为0最少需要进行操作总数，dpUP[1]+dpDOWN[1]就是答案。
    }

    public static void dfsDP(int node,int father) {

        for (int son : graph.get(node)) {
            if (son==father) continue;
            dfsDP(son,node);
            dpUP[node] = Math.max(dpUP[node],dpUP[son]);
            dpDOWN[node] = Math.max(dpDOWN[node],dpDOWN[son]);
            //因为要满足所有子树节点都归零，因此最少的就是所有里最大的那个。
        }

        gift[node] += dpUP[node] - dpDOWN[node];//更新此节点的礼物数。子节点累计过来的加上本身原来的初始值（礼物数）。
        //再更新当前node的变为0所需要的最少加一操作次数或者变为0所需要的最少减一操作次数
        if (gift[node] >= 0) {
            dpDOWN[node] += gift[node];
        }else {
            dpUP[node] -= gift[node];
        }
    }
}
