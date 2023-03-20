package JZoffers;

import java.util.Arrays;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/26
 * 回溯+标记
 */
public class LC79 {
    public static void main(String[] args) {

    }
    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//右、左，上，下（遍历顺序）
    public int m;
    public int n;
    public int l;
    public boolean tag;
    public boolean exist(char[][] board, String word) {
        tag = false;
        m = board.length;
        n = board[0].length;
        l = word.length();
        boolean[][] vis = new boolean[m][n];//记录当前格子在当前路径是否已被访问过，每个格子在同一条搜寻路径只能用一次
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (word.charAt(0)==board[i][j]){//遇到符合第一个字符的就进入dfs
                    dfs(board,0,i,j,word,vis);//vis是引用传递
                }
            }
        }
        return tag;

    }
    public void dfs(char[][] board,int begin,int row,int column,String word,boolean[][] vis){
        //超出边界、已经访问过、已找到目标单词(作为一个剪枝条件，找到就不用再找了）、棋盘格中当前字符已经和目标字符不一致就不用继续往后搜寻，因为这个格子不符合要求，不需要处理
        if (row < 0 || column < 0 || row >= m || column >= n || vis[row][column] ||  begin>=l || board[row][column] != word.charAt(begin) || tag){
            return ;
        }
        //来到这里的都是匹配的，代表当前字符以及前面的都是匹配的。
        if (begin==l-1){//如果长度够了word的长度，就代表搜出来一个结果。
            tag = true;
            return;
        }
        vis[row][column] = true;// 修改当前节点状态
        for (int[] item:dirs){// 遍历四个方位的子节点
            dfs(board,begin+1,row+item[0],column+item[1],word,vis);
        }
        vis[row][column] = false; // 当前节点处理完后要撤销修改，因为不撤销修改的话后面搜寻其他路径时就用不了这个格子了

    }

}
