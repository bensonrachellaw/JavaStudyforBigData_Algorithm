package JZoffers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//完全平方数
public class LC279 {
    public static void main(String[] args) {

    }
    //动态规划做法：类似与硬币凑数LC322
    //定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
    //f(n) = 1 + min{ f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) }//(k为满足k^2<=n的最大的k)
    public int numSquares1(int n) {

        int[] dp = new int[n+1];//dp[i]：表示完全平方数和为i的 最小个数
        for (int i = 1;i <= n;i++) {
            dp[i] = i;
            for (int j = 1; i - j*j >= 0;j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);//遍历j，找到最小的dp[i-j*j]，再加上这次的j*j的1，就是dp[i]的最小个数。
            }
        }
        return dp[n];
    }
    //BFS做法,做减去某些东西的好像都可以用BFS？
    //BFS的做法，比较巧妙。每一次是原数字减去了一个平方数，直到出现第一个0，此时走过的层数就是最小数量，即为答案
    public int numSquares (int n){
        Queue<Integer> que = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int level = 0;
        que.add(n);
        while (!que.isEmpty()) {
            level = level + 1;
            int size = que.size();
            for (int i = 0;i<size;i++) {
                int m = que.poll();//弹出头部的一个元素
                for (int j = 1 ; m - j*j >=0 ;j++){
                    int temp = m - j*j;
                    if (temp==0) return level;
                    if (!set.contains(temp)){
                        que.add(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return 0;
    }
}
