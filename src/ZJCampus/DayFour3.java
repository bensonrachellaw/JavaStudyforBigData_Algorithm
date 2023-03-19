package ZJCampus;

public class DayFour3 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
    /*
    动态规划法
     */
    public static int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        //每根柱子的接水量：min(左边柱子（包括自己）的最高高度，记录右边柱子（包括自己）的最高高度) - 当前柱子高度
        //以下两种求某根柱子的左右最大值是有包括自己本身在内的。
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //动态规划求每个柱子的左边最大值（包括自己）数组
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        //动态规划求每个柱子的右边最大值（包括自己）数组
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            //因此此处不需担心会出现小于0的情况。
        }
        return ans;
    }

    public int trap1(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int iLeftMax = 0,jRightMax = 0;
        while (left < right) {
            iLeftMax = Math.max(iLeftMax, height[left]);
            jRightMax = Math.max(jRightMax, height[right]);
            if (iLeftMax <= jRightMax) {
                ans += iLeftMax - height[left];
                left++;
            } else {
                ans += jRightMax - height[right];
                right--;
            }
        }
        return ans;
    }
    //详细解释版：
    public int trap2(int[] height) {
        //双指针法（动态规划法的空间优化版本）
        //只需要维护两个指针：
        //因为动态数组中的元素我们其实只用一次，然后就再也不会用到了。所以我们可以不用数组，只用一个指针就行了。
        //
        int ans = 0;
        int left = 0;
        //从左往右处理的当前下标
        int right = height.length - 1;
        //从右往左处理的当前下标


        // int leftMax = 0, rightMax = 0;
        //像上面这样写变量名有点不太明朗，因此一次是要更新两个柱子的（left和right）,每个柱子又要看自己的左最大和右最大。
        //因此使用下面的：
        int iLeftMax = 0,jRightMax = 0;
        //分别代表左边处理的柱子的左最大（包括自己）
        //以及右边处理的柱子的右最大（包括自己）
        /**
         假设两柱子分别为 i，j。那么就有 iLeftMax,iRightMax,jLeftMx,jRightMax 这个变量。
         由于 i<j ，故 jLeftMax>=iLeftMax，iRigthMax>=jRightMax.

         那么，如果 iLeftMax<jRightMax，则必有 iLeftMax < iRightMax，
         因为无论右边将来会不会出现更大的iRightMax，都不影响这个结果。用left的左最大来更新left

         如果 iLeftMax>jRightMax，则必有  jLeftMax>jRightMax ，所以我们能接right点的水。（用right的右最大来更新right）

         而上面我们实际上只用到了 iLeftMax，jRightMax 两个变量，故我们维护这两个即可。
         */
        while (left < right) {
            iLeftMax = Math.max(iLeftMax, height[left]);
            jRightMax = Math.max(jRightMax, height[right]);
            if (iLeftMax <= jRightMax) {
                ans += iLeftMax - height[left];
                left++;
            } else {
                ans += jRightMax - height[right];
                right--;
            }
        }
        return ans;
    }
    /**
     其实会发现：left和right最终汇合的点一定是所有柱子中的最高点。
     还会发现：其实最高点（也就是循环未退出时）左边的永远只用左最大来处理
     右边的永远只用右最大来处理。
     其他情况并不会有所处理。为什么呢？
     因为：
     1.当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。
     （不可信的原因是在有jRightMax比ileftMax小的时候，不确定i的右边是否还有没有更高的。）
     所以可以更新i
     2.当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     （两种情况时对称的，所以同理，第一个不可信的就是第二个的可信）
     所以可以更新j
     且在数组中（柱子中），其实最高的柱子一定只有三个位置，要么在中间某一个位置，要么在最左边，要么在最右边。
     如果是在最右或者最最左，那么i，j就只有其中在动，另一个是不会动。
     如果是在中间，那么画个图就知道为什么左边的永远只用左最大来处理，右边的永远只用右最大来处理。（因为所有柱子最高的已经在中间）
     */

}

