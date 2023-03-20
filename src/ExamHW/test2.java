package ExamHW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test2 {
    //全排列LC46
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        Solution solution = new Solution();
        int ans = solution.permuteUnique(s);
        System.out.println(ans);
    }
    static class Solution {
        public ArrayList<List<Character>> res;
        public boolean[] vis;
        public int n;
        public int total = 0;
        public int permuteUnique(String s) {
            char[] nums = s.toCharArray();
            Arrays.sort(nums);
            res = new ArrayList<>();
            vis = new boolean[nums.length];
            n = nums.length;
            ArrayList<Character> list = new ArrayList<>();
            count(nums,0,list);
            return total;
        }
        public void count(char[] nums,int cnt,ArrayList<Character> list) {
            if (cnt==n) {
                res.add(new ArrayList<>(list));
                total += 1;
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
}
