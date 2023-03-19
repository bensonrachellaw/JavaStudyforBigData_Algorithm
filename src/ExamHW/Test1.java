package ExamHW;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner reader = new Scanner(System.in);
        String[] arr = reader.nextLine().split(" ");
        double total = 0;
        for (String s : arr){
            total += s.length();
        }
        double ans = total / arr.length;

        System.out.println(String.format("%.2f", ans));
    }
}
