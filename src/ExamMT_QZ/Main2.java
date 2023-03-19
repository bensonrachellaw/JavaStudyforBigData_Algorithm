package ExamMT_QZ;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] num = new int[n];
        int tag = 0;
        for (int i = 0;i<n;i++) {
            int temp = reader.nextInt();
            num[i] = temp;
            if (temp==0){
                tag=1;
            }
        }
        if (tag==0) {
            System.out.println(0);
        }
        else {
            int min = Integer.MAX_VALUE;
            int cnt;
            for (int i = -1;i<n;i++){
                cnt=0;
                for (int j = 0;j<=i;j++){
                    if (num[j]>=0) {
                        cnt++;
                    }
                }
                for (int k = i+1;k<n;k++){
                    if (num[k]<=0) {
                        cnt++;
                    }
                }
                min = Math.min(cnt,min);

            }
            System.out.println(min);
        }
    }
}
