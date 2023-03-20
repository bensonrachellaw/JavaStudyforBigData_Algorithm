package Algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/14
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {

    }
//   只有先让身高高的先进入队伍，后面身高低的才能根据前面高的来找自己的位置
//    [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//    所以更多时候我们是直接记住了compare（int o1, int o2）方法 return o1 - o2 是升序，return o2 - o1 是降序。那么原因我们不妨跳进去源码看一下。return大于0就把前面往后移动。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1] - o2[1];//身高相同的情况下，按k升序排序，前-后
                }
                return o2[0] - o1[0];//先按身高降序排序，降序就后减前，后-前
            }
        });
        LinkedList<int[]> ans = new LinkedList<>();
        //按照这个顺序就是先处理的都是较高的，所以后处理的都是比前面的低的。保证高的先站，矮的看高的寻找自己的位置。
        for (int[] p : people) {
            ans.add(p[1],p);//插入特定index位置，其他元素相对位置不变。整体往后移。
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
