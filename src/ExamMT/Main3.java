package ExamMT;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] l = new int[m];
        int[] r = new int[m];
        for (int i = 0;i<m;i++){
            l[i] = reader.nextInt();
        }
        for (int i = 0;i<m;i++){
            r[i] = reader.nextInt();
        }
        int[] item = new int[n+1];
        for (int i = 0;i<m;i++){
            for (int j = l[i];j<=r[i];j++){
                item[j]++;
            }
        }
        int cnt = 0;
        for (int i = 1;i<n+1;i++){
            if (item[i]>=2){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
