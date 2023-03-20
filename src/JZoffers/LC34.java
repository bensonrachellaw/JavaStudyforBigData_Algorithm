package JZoffers;

public class LC34 {
    public static void main(String[] args) {

    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};
        int l = -1;
        int r = nums.length;
        //找大于等于target的最小值，以及小于等于target最大值。
        while(l+1<r){
            int mid = (l+r) >> 1;
            if (nums[mid]>=target) {
                r = mid;
            }
            else {
                l = mid;
            }
        }//找大于等于target的最小值
        int a = r;
        int ll = -1;
        int rr = nums.length;
        while(ll+1<rr){
            int mid = (ll+rr) >> 1;
            if (nums[mid]>target) {
                rr = mid;
            }
            else {
                ll = mid;
            }
        }//找小于等于target最大值。
        int b = ll;
        if (a==nums.length || b==-1) return new int[]{-1,-1};//如果不存在target且数组中最大的都比target小或者数组中最小的都比target大。所以越界了。
        if (nums[a]!=target) return new int[]{-1,-1};//数组中最小的<target<数组中最大的
        return new int[]{a,b};
    }
    /**
     * 此题也可以用target+1求大于等于target+1的最小值，然后-1来求b。
     */
}
