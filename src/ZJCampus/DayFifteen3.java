package ZJCampus;

import java.util.HashSet;

public class DayFifteen3 {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int item : nums) set.add(item);
        int ans = 0;
        for (int item : set){
            if (!set.contains(item-1)){//只有当一个数是连续序列的第一个数的情况下才会进入内层循环
                int point = item;
                while (set.contains(item+1)) item++;
                ans = Math.max(ans,item-point+1);
            }
        }
        return ans;
    }
}
