package JZoffers;

import java.util.HashMap;

public class LC560 {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];//记录包括加上当前自己在内的前缀和
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//记录每种前缀和出现的次数。因为数组中有正数负数、k也是可能是正数或者负数。有可能出现一样的前缀和，但是他们的位置是不一样的。
        for (int i = 1;i<nums.length+1;i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
            if (map.containsKey(prefix[i]-k)){
                cnt+=map.get(prefix[i]-k);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }

        return cnt;
    }
    //前缀和
    public int subarraySum1(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];
        prefix[1] = nums[0];
        int cnt = 0;
        for (int i = 2;i<nums.length+1;i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        for (int i = nums.length;i>=1;i--) {
            for (int j = i - 1;j>=0;j--) {
                if (prefix[i]-prefix[j]==k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
