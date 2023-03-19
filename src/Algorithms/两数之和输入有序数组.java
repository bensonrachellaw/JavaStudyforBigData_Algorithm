package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/15
 */
public class 两数之和输入有序数组 {
    public static void main(String[] args) {

    }
    public int[] twoSum_N(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[] {i + 1, j + 1};
            else if (sum > target) j--;
            else i++;
        }
        return null;
    }
    public int[] twoSum_NlogN(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        for (int i = 0 ;i<numbers.length;i++) {
            int remain = target - numbers[i];
            int l ;
            int r ;
            int temp = searchInsert(numbers,remain,i,numbers.length);
            if (temp!= -1) {
                return new int[]{i,temp};
            }
        }
        return null;
    }
    public int searchInsert(int[] nums, int target,int ll,int rr) {
        int l = ll;
        int r = rr;

        while (l+1<r) {
            int mid = (l+r) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        return -1;//此位置就是要插入的位置，其实是找大于等于目标值的最小值。
    }
}
