package ZJCampus;

import java.util.ArrayList;
import java.util.List;

public class DaySix2 {
    public static int[][] visited;
    public static int m;
    public static int n;
    public static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};//分别对应着右，下，左，上、顺时针旋转 对应 题目的顺时针螺旋顺序
    public static List<Integer> list;
    public static void main(String[] args) {

    }

    public static List<Integer> spiralOrder(int[][] matrix){
        m = matrix.length;
        n = matrix[0].length;

        visited = new int[m][n];
        list = new ArrayList<>();

        int x = 0,y = 0;
        int tag = 0;//转向标记
        for (int i = 0;i<m*n;i++){
            list.add(matrix[x][y]);
            visited[x][y] = 1;
            //判断下一个位置是否溢出，如果溢出（不合法）则顺时针修改方向。
            if (x+dirs[tag][0] < 0 || y+dirs[tag][1] < 0 || x+dirs[tag][0] >= m || y+dirs[tag][1] >= n || visited[x+dirs[tag][0]][y+dirs[tag][1]]==1){
                tag++;//碰壁转向
                if (tag==4){
                    tag = 0;
                }
            }
            x += dirs[tag][0];
            y += dirs[tag][1];
        }
        return list;
    }
}
