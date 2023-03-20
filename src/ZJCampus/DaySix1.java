package ZJCampus;

public class DaySix1 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(search(arr,0));
    }

    /**
     *
     * @param nums 数组
     * @param target
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也可能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     *
     *
     * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
     * 这样就可以确定保留哪半边了
     */
    public static int search(int[] nums,int target){
           if (nums.length==0) return -1;
           if (nums.length==1) return nums[0] == target ? 0 : -1;

           int l = -1 , r = nums.length;
           while (l+1 < r){
               int mid = (l + r) >> 1;
               if (nums[mid]==target){
                   return mid;
               }

               if (nums[l+1] <= nums[mid]){
                   if (target>=nums[l+1] && target<nums[mid]){
                       r = mid;
                   }
                   else {
                       l = mid;//左半边有序但是不在左半边
                   }
               }
               else {
                   if (target>nums[mid] && target<=nums[r-1]){
                       l = mid;
                   }
                   else {
                       r = mid;//右半边有序但是不在右半边
                   }
               }
           }

           return -1;
    }
}
