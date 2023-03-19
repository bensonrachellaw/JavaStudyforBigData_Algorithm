package ExamZJ;

import java.util.*;
//3-4月字节模拟题第四题：Atcoder: Q - Flowers
//https://atcoder.jp/contests/dp/tasks/dp_q
//https://www.bilibili.com/video/BV1pE41197Qj (讲解视频）
public class Main4 {
    static long[] segmentTree;
    static int n;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        int[] h = new int[n];
        int[] b = new int[n];
        for (int i = 0;i<n;i++){
            h[i] = reader.nextInt();
        }
        for (int i = 0;i<n;i++){
            b[i] = reader.nextInt();
        }
        segmentTree = new long[n+1];//下标从1开始,表示花的高度，题目规定花的高度唯一且小于等于n。
        // segmentTree数组存的是花的身高小于等于i的，当前最大 花的身高递增序列 能力值的和
        // 递增的条件就把花的身高映射为数组下标，所以就有一种递增关系在这里了。很巧妙。
        for (int i = 0;i<n;i++){
            update(h[i],query(h[i])+b[i]);
        }
        System.out.println(query(n));
    }
    private static int lowBit(int x){
        return x&(-x);//取二进制最右边的1以及1右边的全部的数
    }
    private static long query(int x){//单点查询，也就是查询所有小于这个点的所有线段，比如讲解视频中的。
        long ans = 0;
        for (;x>0;x -= lowBit(x)){
            ans = Math.max(ans,segmentTree[x]);
        }
        return ans;
    }
    private static void update(int x,long value){//单点修改，要修改覆盖了这个点的其他节点，也就是全部父节点。
        for (;x<=n;x += lowBit(x)){
            segmentTree[x] = Math.max(value,segmentTree[x]);
        }
    }
    public static void main1(String[] args) {//超时做法
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] h = new int[n];
        int[] b = new int[n];
        for (int i = 0;i<n;i++){
            h[i] = reader.nextInt();
        }
        for (int i = 0;i<n;i++){
            b[i] = reader.nextInt();
        }
        long[] dp = new long[n];
        dp[0] = b[0];
        long ans = dp[0];
        for (int i = 1;i<n;i++){
            long max = 0;
            for (int j = 0;j<i;j++){
                if (h[j]<h[i]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = b[i] + max;
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
