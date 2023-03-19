package ZJCampus;

public class DayTwenty1 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while(l+1<r){
            int mid = (l+r) >> 1;
            if (nums[mid] == target) return mid;

            if (nums[mid]>target) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        return -1;
    }
}
