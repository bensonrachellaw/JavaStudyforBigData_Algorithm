package JZoffers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    //组合之和2：有重复元素，回溯+大小剪枝(如果不剪枝是不用循环的）
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
            if (target-candidates[i]<0){ // 大剪枝: 重点理解这里剪枝，前提是候选数组已经有序，
                break;
            }
            if (i>begin&&candidates[i]==candidates[i-1]) continue;//小剪枝：避免同一层的重复元素，但是允许不同层的重复。

            combine.add(candidates[i]);
            dfs(combine,candidates,i+1,target-candidates[i]);  // 注意：因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i。每个数在一个组合里是否能选多次的区别体现在这里。
            combine.remove(combine.size()-1);

        }
    }

}
