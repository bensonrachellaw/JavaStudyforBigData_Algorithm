package ExamXC;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 0;i<4*n-n;i++){
            int j = 0;
            while (j<4*n){
                if (j<n){
                    System.out.print("*");
                }
                else if (j>=4*n-n){
                    System.out.print("*");
                }
                else {
                    System.out.print(".");
                }
                j++;
            }
            System.out.println();
        }
        int k = 1;
        for (int i = 4*n-n;i<4*n;i++){
            int z = 0;
            while (z<4*n){
                if (z<k&&z>=4*n-k){
                    System.out.print(".");
                }
                else if (z>=k&&z<k+n){
                    System.out.print("*");
                }
                else if (z>=4*n-k-n&&z<4*n-k){
                    System.out.print("*");
                }
                else {
                    System.out.print(".");
                }
                z++;
            }
            k++;
            System.out.println();
        }
    }
}
