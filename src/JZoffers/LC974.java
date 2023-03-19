package JZoffers;

import java.util.HashMap;
import java.util.Map;

public class LC974 {
    //这题是一定需要用到前缀和的，因为需要求子串的和，
    public static void main(String[] args) {

    }
    //双层循环超时版本
     public static int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        int[] prefix = new int[nums.length+1];
        for(int i = 1;i<=nums.length;i++){
            prefix[i] = (nums[i-1]%k + prefix[i-1]%k)%k;
        }
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length+1;j++){
                if((prefix[j]-prefix[i])%k==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //字节:同余定理，只需要计算所有前缀和的模k的值的数量即可。(Pi-Pj)%k = 0 => Pi%k=Pj%k
    public static int subarraysDivByK1(int[] nums, int k) {
        int cnt = 0;
        int[] prefix = new int[nums.length+1];
        for(int i = 1;i<=nums.length;i++){
            prefix[i] = (nums[i-1]%k + prefix[i-1]%k)%k;
        }

        int[] mod = new int[k];//用一个数组记录所有的余数的数量。也可以用map
        for(int i = 0;i<=nums.length;i++){//别忘了等于0的情况，也就是取所有前缀的和的情况。
            mod[(prefix[i]%k+k)%k]++;//因为可能是负数，所以需要变成正数。余k后再加k再余k即可。（再余k是因为余数等于0的情况）
//            Math.floorMod(prefix[i],k) 也可以这样处理负数的情况。
        }
        for(int ans : mod){
            cnt += (ans*(ans-1)/2);
        }
        return cnt;
    }
    public static int subarraysDivByK2(int[] nums,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int[] prefix = new int[nums.length+1];
        for(int i = 1;i<=nums.length;i++){
            prefix[i] = (nums[i-1]%k + prefix[i-1]%k)%k;
        }
        for(int i = 0;i<=nums.length;i++){
            int mod = Math.floorMod(prefix[i],k);
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            cnt += (entry.getValue()*(entry.getValue()-1)/2);
        }
        return cnt;
    }


}
