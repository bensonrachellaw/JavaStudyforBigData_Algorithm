package JZoffers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/24
 * 子集Ⅱ：在LC78子集的递归法2的基础上加了排序和剪枝
 */
public class LC90 {
    public static void main(String[] args) {

    }
    //递归加剪枝法，在78子集的递归法2的基础上加了排序和剪枝
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放某个符合条件结果
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//带有重复元素的需要去重的必须要先有排序操作，让重复的元素排在一起。
        dfs(nums,0);
        return result;
    }
    public void dfs(int[] nums,int begin){
        result.add(new ArrayList<>(path));//必须新造（拷贝）一个！遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        for (int i = begin;i<nums.length;i++){
            if (i>begin && nums[i]==nums[i-1]) continue;//剪枝：在同一深度的两个不同的分支，如果当前元素和前面的元素相同，我们就跳过。要对同一树层使用过的元素进行跳过
            path.add(nums[i]);//做出选择
            dfs(nums,i+1);//递归进入下一层，注意i+1，标识下一个选择列表的开始位置，最重要的一步
            path.removeLast();//撤销选择
        }
    }
}
