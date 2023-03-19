package JZoffers;

import java.util.HashMap;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/27
 */
public class LC96 {
    public static void main(String[] args) {

    }
    //注意[1，2，3，4]和[5，6，7，8]所代表的二叉搜索数的数量是一样。和序列的内容无关，只和序列的长度有关（数量）
    //回溯递归+Map
    HashMap<Integer,Integer> map = new HashMap<>();
    public int numTrees_re(int n){
        if (n==1||n==0){
            return 1;
        }
        int cnt = 0;
        if (map.containsKey(n)) return map.get(n);
        for (int i = 1;i<=n;i++){
            int left = numTrees_re(i-1);
            int right = numTrees_re(n-i);
            cnt += left*right;
        }
        map.put(n,cnt);
        return cnt;
    }
    //dp（卡特兰数）:
    public int numTrees_dp(int n){
        /**
         * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数
         * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
         * 当 i 为根节点时，除去i这个节点，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
         * f(i) = G(i-1)*G(n-i)
         *
         * 综合两个公式可以得到 卡特兰数 公式
         * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
         *
         */
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2;i<=n;i++){
            for (int j = 0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];

    }
}
