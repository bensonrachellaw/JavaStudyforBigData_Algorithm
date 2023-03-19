package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/17
 */
public class LC75 {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums){
        //双（三？）指针法：一次遍历，如果是0，则交换到到表头，如果是2，则交换到表尾。
        int cur = 0;//当前指针
        int left = 0;//放0的指针
        int right = nums.length-1;//放2的指针
        while (cur<=right){
            if (nums[cur]==0){//遇到0的话，就交换到0区，然后0指针往后移一格。
                swap(nums,cur,left);
                left++;
                cur++;//当前指针往后移一格
            }
            else if (nums[cur]==2){//遇到2的话，就交换到2区，然后2指针往前面移一格。
                swap(nums,cur,right);
                right--;
                //这里不能移动当前指针，因为“注意 2 挪完如果换出来的不是 1，那么指针要回退，因为 0 和 2 都是需要再次移动的”
            }
            else {//遇到1的话，什么都不用做，直接移动当前指针即可。
                cur++;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors1(int[] nums){
        //利用三指针，移动赋值法：
        /**
         * 理解：三个指针num1、num2、num3将数组nums分成了3个分区，从左往右依次存储0、1、2。 三个指针分别指向各自分区的尾部。 从左到右遍历数组nums，
         * (1)如果nums[i]=0,则1、2区都后移一个位置，给新来的0腾地方。
         * (2)如果是nums[i]=1，同样，2区后移一个位置，给新来的1腾地方。前面的0区无影响。
         */
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]==0){
                nums[num2++] = 2;//2区间赋值后移，相当于腾出位置
                nums[num1++] = 1;//1区间赋值后移
                nums[num0++] = 0;//0区间扩大
            }
            else if (nums[i]==1){
                nums[num2++] = 2;//2区间赋值后移
                nums[num1++] = 1;//1区间扩大
            }
            else {
                nums[num2++] = 2;//2区间扩大
            }
        }
    }
}
