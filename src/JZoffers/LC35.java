package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/7/25
 * 35. 搜索插入位置
 */
public class LC35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int l = -1;
        int r = nums.length;

        while (l+1<r) {
            int mid = (l+r) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        return l+1;//返回r也能AC,因为退出while循环时总有l + 1 = r
    }
    public int searchInsert1(int[] nums, int target) {
        int l = -1;
        int r = nums.length;

        while (l+1<r) {
            int mid = (l+r) >> 1;
            // if (nums[mid] == target) return mid;
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        return r;//此位置就是要插入的位置，其实是找大于等于目标值的最小值。l+1也能AC,因为退出while循环时总有l + 1 = r
    }
}
