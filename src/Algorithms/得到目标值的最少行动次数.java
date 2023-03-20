package Algorithms;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2023/3/14
 */
public class 得到目标值的最少行动次数 {
    public static void main(String[] args) {

    }
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while(maxDoubles>0 && target > 1){
            if(target%2==1){
                target-=1;
                res++;
            }
            if(target>1){
                maxDoubles-=1;
                target/=2;
                res++;
            }
        }
        if(target>1)
            res+=(target-1);
        return res;
    }
}
