package JZoffers;
import java.util.*;
/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/9
 * LC11：《盛最多水的容器》
 */
public class LC11 {
    public static void main(String[] args) {

    }
    //暴力做法是铁超时的，因为需要剪枝掉一部分情况不进行计算来提高速度。
    //使用双指针加贪心的思路进行解决。削减搜索空间

    /**
     * 具体做法：设置左右两个指针，初始位置分别指向数组的左端点和右端点。
     * 比较高度数组的两个位置的值，哪个小就移动哪个指针（左指针往右移，右指针往左移），如果相等就选其中一个进行移。
     * 退出循环的条件为两个指针相遇（即位置相等了）
     * 在循环过程中维护更新max（面积：两个指针的距离乘以两个指针的数组的值的较小值）。
     *
     * 正确性解释：移动短板而非移动长板的原因是：移动长板只可能减小面积。而移动短板有可能减小面积，也有可能保持不变，但是也有可能增大面积！！
     * 而每次移动短板，相当于剪掉了一部分的情况（即短板不动，长板动的情况），但是这部分情况并不会导致面积最大值丢失，也就是说剪掉不可能对更新max有作用的情况。
     *
     * 借鉴官方题解评论：
     * 感觉这个移动有点博弈论的味了，每次都移动自己最差的一边，虽然可能变得更差或者不变或者更好，但是总比一定减小强，动最差的部分可能找到更好的结果。
     * 但是动另一边总会更差。
     */
    public int maxArea(int[] height) {
        int l = 0;//左指针
        int r = height.length-1;//右指针
        int max = 0;
        while(l<r){
            max = Math.max(max,(r-l)*(Math.min(height[l],height[r])));//维护更新max：面积
            if(height[l]>height[r]) r--;//向内移动
            else l++;//向内移动
        }
        return max;
    }
}
