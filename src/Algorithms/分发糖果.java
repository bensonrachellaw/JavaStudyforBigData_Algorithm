package Algorithms;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/14
 */
public class 分发糖果 {
    public static void main(String[] args) {
        candy(new int[]{1, 2, 2,4,5,6,7,88,300,4,4,4,8,8,8888,888,8,8,88,86,8678});
    }
    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            //更新所有下降段，更新的是每两个元素的左边
        }
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        //更新所有上升段，更新的是每两个元素的右边

        int count = 0;
        //只有在转折点才会有两个选择，选其中的较大值满足两边的规则。
        for(int i = 0;i<ratings.length;i++) {
            count += Math.max(left[i],right[i]);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        return count;
    }
}
