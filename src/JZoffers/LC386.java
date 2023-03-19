package JZoffers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
//https://leetcode-cn.com/problems/lexicographical-numbers/ （字节面试）
public class LC386 {
    List<Integer> ans = new ArrayList<>();
    //迭代法
    public List<Integer> lexicalOrder1(int n) {
        int num = 1;
        for (int i = 0; i<n ;i++){
            ans.add(num);
            if(num*10<=n) num = num*10;
            else{
                while(num%10==9||num>=n){
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }
    //dfs法简单易懂
    public List<Integer> lexicalOrder2(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }
    void dfs(int cur, int limit) {
        if (cur > limit) return ;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, limit);
    }
    //排序法，使用Arrays.sort
    public List<Integer> lexicalOrder3(int n) {
        String[] s = new String[n];
        for (int i = 1;i<=n;i++){
            s[i-1] = String.valueOf(i);
        }
        Arrays.sort(s);
        List<Integer> list = new ArrayList<>();
        for (String ss : s){
            list.add(Integer.parseInt(ss));
        }
        return list;
    }
    //自己写排序的方法
    static Random random = new Random();
    public List<Integer> lexicalOrder(int n) {
        String[] s = new String[n];
        for (int i = 1;i<=n;i++){
            s[i-1] = String.valueOf(i);
        }
        quicksort(s,0,n-1);

        List<Integer> list = new ArrayList<>();
        for (String ss : s){
            list.add(Integer.parseInt(ss));
        }
        return list;
    }
    public static void quicksort(String[] nums,int l,int r){
        if (l>r){
            return;
        }
        int pivot = random.nextInt(r-l+1) + l;
        swap(nums,l,pivot);

        int i = l;

        for(int j = l+1;j<=r;j++){
            if (((nums[j]).compareTo(nums[l])) < 0){//如果是找最大数的话就>0
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i,l);
        quicksort(nums,l,i-1);
        quicksort(nums,i+1,r);

    }

    public static void swap(String[] nums,int i,int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
