package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/19
 * LC695：岛屿的最大面积（与岛屿问题那题同样思路）(腾讯实习一面）
 */
public class LC695 {
    public static int m;
    public static int n;
    public static int temp;
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {

    }
    public static int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (grid[i][j]==1){
                    temp = 0;//维护一个计数器。
                    dfs(grid,i,j);
                    max = Math.max(max,temp);
                }
            }
        }
        return max;
    }

    public static void dfs(int[][] grid,int row,int column){
        if (row < 0 || column < 0 || row >= m || column >= n || grid[row][column] == 0){
            return ;
        }

        grid[row][column] = 0;
        temp++;
        for (int[] item:dirs){
            dfs(grid,row+item[0],column+item[1]);
        }
    }
}
