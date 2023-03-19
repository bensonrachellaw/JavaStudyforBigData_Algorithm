package ZJCampus;

public class DayThirteen1 {
    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;

        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1]>nums2[p2]){
                nums1[tail--] = nums1[p1--];
            }
            else {
                nums1[tail--] = nums2[p2--];
            }
        }
        while (p2>=0){
            // nums1[p2] = nums2[p2];
            // p2--;
            // 因为这里用两个p2，所以不能在中括号里p2--；
            nums1[p2--] = nums2[tail--];
        }
    }
    /**
     * 合并两个有序数组并去重——美团:
     * 因为是有序的，每次比较完两个值后判断前一个放进数组里的值是不是和这次将要放进数组的值相等就行了，
     * 如果相等的话这一步比较出来的值就不放进数组
     */
}
