package ExamXC_QZ;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/30
 */
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        for (int i = 0;i<n;i++) {
            char[] c = reader.nextLine().toCharArray();
            if (c[c.length-1] % 2 == 0) {
                System.out.println(String.valueOf(c));
            }
            else {
                int tag = 0;
                for (int ii = 0;ii<c.length;ii++) {
                    if (c[ii] % 2==0) {
                        tag=1;
                        swap(c,ii,c.length-1);
                        break;
                    }
                }
                if (tag==0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(String.valueOf(c));
                }
            }
        }
//        System.out.println()
    }
    public static void swap(char[] nums,int i,int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
