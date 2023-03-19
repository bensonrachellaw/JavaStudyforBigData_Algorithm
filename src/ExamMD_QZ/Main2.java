package ExamMD_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/14
 */
public class Main2 {
    public static void main(String[] args) {

    }
    public static int[] solution (int[][] input) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = input.length;
        int[] temp = input[0];
        for (int i = 1;i<n;i++) {
            temp = two(temp,input[i]);
        }
        return temp;
    }

    public static int[] two (int[] a ,int[] b){
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        for (int x : b) {
            if (set.contains(x)) {
                list.add(x);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i<list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
