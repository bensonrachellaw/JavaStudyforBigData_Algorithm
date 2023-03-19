package JZoffers;

import java.util.*;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/23
 */
public class LC78 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsets(int[] nums) {
        //热评第一方法：遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集。（从前往后和从后往前都行）本质是动态规划思想，属于较简单的线性动规。
        //取出所有总队列中现有的所有子集，每个子集加上当前遍历到的元素，再放进总队列中，注意所有旧子集依旧保持它的原样存储在总队列中。
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        ans.add(empty);//先把空集入队
        for (int i = 0;i<n;i++){
            int size = ans.size();//这里如果不单独拎出来保存一个副本的话，会导致死循环。因为ans.size()在二层循环中会不断变化（变长）
            for (int j = 0;j<size;j++){
                List<Integer> temp = new ArrayList<>(ans.get(j));//如果不新造一个，则是指向同一地址，操作的其实是原list（旧子集）。
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
    public List<List<Integer>> subsets1(int[] nums) {
        //二进制枚举法：集合的每个元素，都有可以选或不选两个选择，用二进制和位运算，可以很好的表示
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {//设集合长度为n（n个元素）。表示000……000 至 111……111（都是n长度）。1<<nums.length 等价于 2^nums.length,对于n个数字的数组，共2^n个子集
            t.clear();
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 1) {//遍历每一位，每次右移一个单位然后与1进行与操作运算，从低位到高位逐个取其二进制位，并判断是否为1。若为1则放入对于nums中的元素。
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));//必须新造一个！
        }
        return ans;
    }
    //递归法1：
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    public void dfs (int cur,int[] nums){//cur表示当前位置,原序列的每个位置在答案序列中的状态有被选中和不被选中两种，我们用t存放已经被选出的数字
        if (cur == nums.length){
            ans.add(new ArrayList<>(t));
            return;
            //在整个递归调用的过程中，cur 是从小到大递增的，当 cur 增加到 n 的时候，记录答案并终止递归。
        }
        //每个元素考虑取和不取两种情况，
        t.add(nums[cur]);//取
        dfs(cur+1,nums);
        t.remove(t.size()-1);//不取
        dfs(cur+1,nums);
    }
    //递归法2：想象一颗树 https://leetcode.cn/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets3(int[] nums) {
        dfs2(nums,0);
        return result;
    }
//    [1,2,3]的输出顺序是：[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    public void dfs2(int[] nums,int begin){
        result.add(new ArrayList<>(path));//必须新造（拷贝）一个！遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        for (int i = begin;i<nums.length;i++){
            path.add(nums[i]);//做出选择
            dfs2(nums,i+1);//递归进入下一层，注意i+1，标识下一个选择列表的开始位置，最重要的一步
            path.removeLast();//撤销选择
        }
    }


}
