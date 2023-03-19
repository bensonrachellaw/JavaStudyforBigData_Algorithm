package ExamMT_QZ2;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();
        String xs = reader.nextLine();
        String s = reader.nextLine();
        int[][] matrix = new int[n][m];
        matrix[0][0] = 1;
        int all = n * m ;
        int cnt = 1;
        int x = 0,y = 0;
        int tag = 0;
        int tag_i = -1;
        for (int i = 0; i<k ;i++) {
            if (s.charAt(i)=='W') {
                x = x - 1;
                if (matrix[x][y]==0) {
                    matrix[x][y]=1;
                    cnt++;
                }
                else {

                }
                if (cnt==all){
                    tag=1;
                    tag_i = i;
                    break;
                }
            }
            if (s.charAt(i)=='D') {
                y = y + 1;
                if (matrix[x][y]==0) {
                    matrix[x][y]=1;
                    cnt++;
                }
                else {

                }
                if (cnt==all){
                    tag=1;
                    tag_i = i;
                    break;
                }
            }
            if (s.charAt(i)=='S') {
                x = x + 1;
                if (matrix[x][y]==0) {
                    matrix[x][y]=1;
                    cnt++;
                }
                else {

                }
                if (cnt==all){
                    tag=1;
                    tag_i = i;
                    break;
                }
            }
            if (s.charAt(i)=='A') {
                y = y - 1;
                if (matrix[x][y]==0) {
                    matrix[x][y]=1;
                    cnt++;
                }
                else {

                }
                if (cnt==all){
                    tag=1;
                    tag_i = i;
                    break;
                }
            }
        }
        if (tag==1){
            System.out.println("Yes");
            System.out.println(tag_i+1);
        }
        else {
            System.out.println("No");
            System.out.println(all-cnt);
        }

    }
}
