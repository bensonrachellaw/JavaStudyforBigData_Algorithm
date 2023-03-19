package ZJCampus;

public class DayEight2 {
    public static int m;
    public static int n;
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {

    }
    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    public static void dfs(char[][] grid,int row,int column){
        if (row < 0 || column < 0 || row >= m || column >= n || grid[row][column] == '0'){
            return ;
        }

        grid[row][column] = '0';
        for (int[] item:dirs){
            dfs(grid,row+item[0],column+item[1]);
        }
    }
}
