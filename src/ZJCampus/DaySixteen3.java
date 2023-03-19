package ZJCampus;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DaySixteen3 {

    public static void main(String[] args) {

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0 ; i<nums.length;i++){
            if(!que.isEmpty() && que.peek() <= i-k) que.pollFirst(); // 判断当前队列中队首的值是否有效
            // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序，队首为最大值。
            while(!que.isEmpty() && nums[que.peekLast()]<=nums[i]) que.pollLast();
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            que.offer(i); // 添加当前值对应的数组下标
            if (i>=k-1) res.add(nums[que.peek()]); // 当窗口长度为k时,保存当前窗口中最大值
        }
        //核心代码如上。看YXC的视频。
        int[] ans = new int[res.size()];
        for (int i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
