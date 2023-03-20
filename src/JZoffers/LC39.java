package JZoffers;

import java.util.*;
public class LC39 {
    //组合之和：无重复元素。回溯+剪枝(如果不剪枝是不用循环的）
    public static List<List<Integer>> res;
    public static void main(String[] args) {

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates); // 排序是剪枝的前提
        dfs(combine,candidates,0,target);
        return res;

    }
    public static void dfs(List<Integer> combine,int[] candidates,int begin,int target){
        if (target==0){
            res.add(new ArrayList<>(combine));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin ;i<candidates.length;i++){
            if (target-candidates[i]<0){ // 重点理解这里剪枝，前提是候选数组已经有序，
                break;
            }
            else {
                combine.add(candidates[i]);
                dfs(combine,candidates,i,target-candidates[i]);  // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                combine.remove(combine.size()-1);
            }
        }
    }
    /**
     * 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
     * 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
     *
     */
}
