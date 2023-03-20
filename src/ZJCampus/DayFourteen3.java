package ZJCampus;
import java.util.*;
public class DayFourteen3 {
//    135. 分发糖果：相邻两个孩子评分更高的孩子会获得更多的糖果。
    public static void main(String[] args) {

    }
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        //更新所有上升段，更新的是每两个元素的右边
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            //更新所有下降段，更新的是每两个元素的左边
        }
        int count = 0;
        //只有在转折点才会有两个选择，选其中的较大值满足两边的规则。
        for(int i = 0;i<ratings.length;i++) {
            count += Math.max(left[i],right[i]);
        }
        return count;
    }

}
