package ZJCampus;
import java.util.*;
public class DaySix3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int X = reader.nextInt();

        int[] OP = new int[n];
        int[] NP = new int[n];
        int[] weight = new int[n];

        int count = 0;
        long extra = 0;
        for (int i = 0;i<n;i++){
            OP[count] = reader.nextInt();
            NP[count] = reader.nextInt();
            weight[count] = reader.nextInt();
            NP[count] = NP[count] + NP[count] - OP[count];//比作01背包的物品重量。
            if (NP[count]<=0){
                extra += weight[count];
                X -= NP[count];
            }
            else {//可以覆盖掉NP[count]<=0的不参与后面的01背包运算。
                count++;
            }
        }

        long[] dp = new long[X+1];
        for (int i = 0 ;i<count;i++){
            for (int j = X;j>=NP[i];j--){
                dp[j] = Math.max(dp[j-NP[i]]+weight[i],dp[j]);
            }
        }
        System.out.println(dp[X]+extra);
    }
}
