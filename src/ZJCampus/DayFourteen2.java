package ZJCampus;

import java.util.*;
//《合并区间》。如果我们按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的。

/**
 * 我们用数组 merged 存储最终的答案。
 *
 * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
 *
 * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
 *
 * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
 */
public class DayFourteen2 {

    public static void main(String[] args) {

    }
    public static int[][] merge(int[][] intervals) {
        //先按照起点排序。
        if (intervals.length == 0) {
            return new int[0][2];
        }
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        ArrayList<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1;i<intervals.length;i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l>merged.get(merged.size()-1)[1]){
                merged.add(new int[]{l,r});
            }
            else {
                merged.get(merged.size()-1)[1] = Math.max(r,merged.get(merged.size()-1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);//注意list转数组需要在括号中指定类型。
    }
}
