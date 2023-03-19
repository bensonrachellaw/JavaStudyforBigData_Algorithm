package JZoffers;


public class JianZhi51 {
    public static void main(String[] args) {

    }
    //LC912：归并排序（完全不用变）加一行代码即可。
    //利用归并排序算法过程里天然存在的前后两段子区间之间的前后位置关系来做。也要利用两个子区间内部都是有序的来用O（1）来一次累加一批。res += mid - i + 1;
    //注意计算逆序对数量时：因为按照归并的思路，是小的那个会被丢掉（指针往后移）（不是大的被丢掉），因此要用前子区间的数来算逆序对的数量，也就是说不能用j来计算，要用mid-i+1来计算。
    //算的是：以后子区间的每个比较后为小的数在前子区间中所产生的逆序对的数量。
    private int res=0;
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        return res;
    }
    public void mergeSort(int[] nums ,int left , int right , int[] tmp) {
        if (left>=right) return;//只有一个或者没有，就不需要排序了。
        int mid = (left+right) >> 1;

        mergeSort(nums,left,mid,tmp);
        mergeSort(nums,mid+1,right,tmp);

        int k = 0,i = left,j = mid+1;

        while (i<=mid && j<=right) {
            if (nums[i]<=nums[j]) tmp[k++] = nums[i++];//相等的话一般是取前半段的那个数，保证稳定性。等号位置不变，因为如果if(nums[i]<nums[j]) 少了等号 这样会把相等的数字也计算进逆序对个数里，要严格小于才能算逆序对。
            else {
                res += mid - i + 1;//累加当前数的所产生的逆序对的数量。
                // 当出现某个后子区间的数比前子区间的当前指针指向的数小的时候，就需要加一次此时这个后子区间的数所产生的逆序对数量（前子区间里i后面的都比这个数要大），res += mid - i + 1
                // 然后这个数便会下线（丢掉）（指针往后移）
                tmp[k++] = nums[j++];
            }
        }
        //哪边没有循环完，就直接都接到后面。
        while (i<=mid) {
            tmp[k++] = nums[i++];
        }

        while (j<=right) {
            tmp[k++] = nums[j++];
        }
        //把排完序的数复制回原数组nums里面，因为上层递归用的是两个排好序的原数组的来进行合并。
        k=0;
        while (left<=right){
            nums[left++] = tmp[k++];
        }
    }
}
