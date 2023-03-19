package JZoffers;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public List<List<Integer>> res;
    public boolean[] vis;
    public int n;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        vis = new boolean[nums.length];
        n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        count(nums,0,list);
        return res;
    }
    public void count(int[] nums,int cnt,ArrayList<Integer> list) {
        if (cnt==n) {
            res.add(new ArrayList<>(list));
            //list只有一份，在遍历过程中会add，remove，最终回溯会root的时候，list就是空的。所以那里每次都要new一个对象，将list拷贝过去。如果只是add(list)，传进去的是一个引用，最后都会变成空。因为list在回溯中要增增减减。
            return;
        }
        for (int i = 0;i<n;i++) {
            if (!vis[i]){
                vis[i] = true;
                list.add(nums[i]);
                count(nums,cnt+1,list);
                vis[i] = false;
                list.remove(list.size()-1);
            }
        }
        return;
    }
    //含重复数字。
    public void count1(int[] nums,int cnt,ArrayList<Integer> list) {
        if (cnt==n) {
            res.add(new ArrayList<>(list));
            //list只有一份，在遍历过程中会add，remove，最终回溯会root的时候，list就是空的。所以那里每次都要new一个对象，将list拷贝过去。如果只是add(list)，传进去的是一个引用，最后都会变成空。因为list在回溯中要增增减减。
            return;
        }
        for (int i = 0;i<n;i++) {
            if (!vis[i]){
                if (i>0 && nums[i]==nums[i-1] && !vis[i-1]) continue;
                //(上一个元素没被用过说明同树层),建议使用!vis[i-1]
                //!vis[i-1]使用重复数据的第一个，如果改为vis[i-1]则使用重复数据的最后一个，
                //因此，used[i-1] 前面加不加感叹号的区别仅在于保留的是相同元素的顺序索引，还是倒序索引。
                vis[i] = true;
                list.add(nums[i]);
                count(nums,cnt+1,list);
                vis[i] = false;
                list.remove(list.size()-1);
            }
        }
        return;
    }

}
