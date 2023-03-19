package Exam4399_QZ;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] A = new int[]{12,24,8,32};
        int[] B = new int[]{13,25,32,11};
        // boolean[] vis = new boolean[n];
        int n = B.length;
        boolean[] vis = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(A);
        for (int i = 0;i< n;i++ ) {
            int t = B[i];
            int tag = 0;
            for (int j = 0;j< n;j++ ) {
                if (A[j]>t && vis[j]==false) {
                    tag=1;
                    vis[j] = true;
                    list.add(A[j]);
                    break;
                }
            }
            if (tag==0) {
                for (int j = 0;j< n;j++ ) {
                    if (vis[j]==false) {

                        vis[j] = true;
                        list.add(A[j]);
                        break;
                    }
                }

            }

        }
        System.out.println(list);
    }
}
