package ExamYW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        int index;
        if (n%2==0) {
            index = 2;
        }
        else {
            index = 1;
        }
        long ans = 0;
        for (int i = index;i<=n;i+=2){
            ans += i;
        }
        System.out.println(ans);
    }
}
