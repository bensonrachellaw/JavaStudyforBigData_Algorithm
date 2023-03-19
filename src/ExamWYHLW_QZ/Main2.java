package ExamWYHLW_QZ;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        int ans = 0;
        if (n%2==1){
            for (int i = 0;i<n;i++) {

            }
        }
        else {
            for (int i = 0;i<n-2;i++) {
                if (a[i]!=a[i+1] && a[i] < a[i+2]) {
                    ans += a[i+2] - a[i];
                }
            }
        }

        System.out.println(ans);
    }
}
