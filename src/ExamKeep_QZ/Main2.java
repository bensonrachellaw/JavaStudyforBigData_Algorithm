package ExamKeep_QZ;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/30
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
//        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。

        System.out.println(maximumSwap(11564));
    }
    public static int maximumSwap (int num) {
        // write code here
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        for (int i = 0;i<s.length();i++) {
            char max = s.charAt(i);
            int k = -1;
            for (int j = i+1;j<s.length();j++) {
                if (s.charAt(j)>max){
                    max = s.charAt(j);
                    k = j;
                }
            }
            if (max>s.charAt(i)) {

                swap(arr,i,k);
                break;
            }
        }
        String ss = String.valueOf(arr);
        return Integer.parseInt(ss);
    }
    public static void swap(char[] nums,int i,int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}