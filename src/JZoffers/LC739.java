package JZoffers;

import java.util.Deque;
import java.util.LinkedList;

public class LC739 {
    //《每日温度》
    public static void main(String[] args) {

    }
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            //华为面试题目：也可以从后往前用单调递增栈来求。（大概意思是：求每个任务前面第一个比自己权值小的任务）
            //本题是单调递减栈，栈底为大，栈顶为小，单调递减。从左至右进行。
            //判别是否需要使用单调栈，如果需要找到左边或者右边第一个比当前位置的数大或者小的数，则可以考虑使用单调栈；
            int[] ans = new int[temperatures.length];
            Deque<Integer> stack = new LinkedList<>();//存的是下标；
            for (int i =  0 ; i<temperatures.length ; i++){
                while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    int temp = stack.pop();
                    ans[temp] = i - temp;
                }
                stack.push(i);
            }
            /**
             一开始相反了。原来栈存的是需要被计算答案的位置（下标），而不是用于计算别人的答案的位置（下标）

             维护递减栈，后入栈的元素总比栈顶元素小。

             比对当前元素与栈顶元素的大小
             条件1：若当前元素 < 栈顶元素：入栈
             条件2：若当前元素 > 栈顶元素：一个个弹出全部符合条件的栈顶元素，记录两者下标差值即为所求天数。结束while循环后的元素也要入栈。
             */
            return ans;
        }
    }
}
