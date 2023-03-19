package ExamKeep_QZ;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/30
 */
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();

//        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。

        int[] a = {0,0};
        int[][] b = {{0,0}};
        System.out.println(Arrays.toString(sleepTime(a, b)));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 小 K 的睡眠时长
     * @param timeToBed int整型一维数组 小 K 上床睡觉时间，格式为 [H, M]
     * @param alarms int整型二维数组 闹钟列表，每一项为 [h, m]
     * @return int整型一维数组
     */
    public static int[] sleepTime (int[] timeToBed, int[][] alarms) {
        // write code here
//        if (alarms.length==0)
        Arrays.sort(alarms,(o1,o2)->(o1[0]-o2[0]));
        int tag = 0;
        int[] arr;
        int h = -1,m=-1;
        for (int i = 0;i<alarms.length;i++) {
            if ( (alarms[i][0] == timeToBed[0] && alarms[i][1] >= timeToBed[1]) || alarms[i][0] > timeToBed[0]) {
                tag=1;
                h = alarms[i][0] - timeToBed[0];
                m = alarms[i][1] - timeToBed[1];
                if (alarms[i][1] < timeToBed[1]) {
                    h = h - 1;
                    m = 60+m;
                }

                break;
            }
        }
        if (tag==0) {
            h = 23-timeToBed[0]+alarms[0][0] ;
            m = 60-timeToBed[1]+alarms[0][1] ;
            if (m>=60) {
                h=h+1;
                m=m-60;
            }
        }
        arr = new int[]{h,m};
        return arr;
    }
}