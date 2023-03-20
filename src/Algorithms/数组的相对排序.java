package Algorithms;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Description: JavaStudyforBigData_Algorithm
 * Created by L6BD610_Luo on 2023/3/20
 */
public class 数组的相对排序 {
    public static void main(String[] args) {

    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<arr1.length;i++) {
            list.add(arr1[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<arr2.length;i++) {
            map.put(arr2[i],i);
        }
        //外部的map可以放进来compare函数里
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) || map.containsKey(o2)) {
                    //map.containsKey(o1) || map.containsKey(o2)的意思：o1和o2是list里有相对位置的两个元素，o1在o2前面
                    //如果o1有，o2没有，那赋予o2一个最大值，对应了先排arr2中出现的，没有出现的放后面。return小于0，相对位置不变
                    //而如果o2有，o1没有，那赋予o1一个最大值，对应了先排arr2中出现的，没有出现的放后面。return大于0，把前面往后移动换到后面去。
                    //而如果o1有，o2也有，那对应了在arr2中出现的要按照arr2的位置顺序排好。因此使用在arr2中的index来排序，即把这些在arr2中出现的arr1的元素排成按照arr2下标的对应顺序。
                    //return o1 - o2 是升序，return o2 - o1 是降序。那么原因我们不妨跳进去源码看一下。return大于0就把前面往后移动。
                    return map.getOrDefault(o1, 1001) - map.getOrDefault(o2, 1001);//因为数组长度的最大就是1000，所以下标最大999.
                }
                return o1 - o2;//而如果o2没有，o1没有，两个都没有，对应题目中说的“未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。” 则return o1 - o2 是升序即可
            }
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}
