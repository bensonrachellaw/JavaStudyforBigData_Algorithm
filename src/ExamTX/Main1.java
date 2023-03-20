package ExamTX;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String[] arr = new String[n];
        String x = reader.nextLine();
        for (int i = 0;i<n;i++){
            arr[i] = reader.nextLine();
        }
        int m = arr[0].length();
        int[] ans = new int[arr[0].length()];
        for (int j = 0;j<m;j++){
            StringBuilder s = new StringBuilder("");
            for (int i = 0;i<n;i++){
                s.append(arr[i].charAt(j));
            }
            ans[j] = Integer.parseInt(String.valueOf(s));
        }
        Arrays.sort(ans);
        for (int i = 0;i<m;i++){
            if (i==m-1){
                System.out.print(ans[i]);
            }
            else {
                System.out.print(ans[i]+" ");
            }
        }

    }
}
