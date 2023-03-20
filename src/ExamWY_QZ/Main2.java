package ExamWY_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/27
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        for (int i = 0;i<T;i++) {
            int n = reader.nextInt();
            int[][] arr = new int[n][4];
            for (int j = 0;j<n;j++) {
                for (int jj = 0;jj<4;jj++) {
                    arr[j][jj] = reader.nextInt();
                }
            }
            int[][] grid = new int[10050][10050];
            int cnt = 0;
            for (int j = 0;j<n;j++) {
                int x0 = arr[j][0],y0 = arr[j][1],x1 = arr[j][2],y1 = arr[j][3];
                for (int x = x0;x<x1;x++) {
                    for (int y = y0;y<y1;y++) {
                        grid[x][y] = grid[x][y] + 1;
                        if (grid[x][y]>=2) {
                            cnt = cnt + 1;
                        }
                    }
                }
            }
            int sq = 0,tag;
            for (int j = 0;j<n;j++) {
                tag = 0;
                int x0 = arr[j][0],y0 = arr[j][1],x1 = arr[j][2],y1 = arr[j][3];
                for (int x = x0;x<x1;x++) {
                    for (int y = y0;y<y1;y++) {
                        if (tag==0 && grid[x][y]>=2) {
                            tag = 1;
                        }
                    }
                }
                if (tag==1) {
                    sq += ((x1-x0)*(y1-y0));
                }
            }
            sq = sq -cnt;
            System.out.println(sq);
        }
    }
}
