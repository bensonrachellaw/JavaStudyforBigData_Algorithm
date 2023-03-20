package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiggestIntegerinaMatrix {

    public static int[][] nums;
    public static int[][] visited;
    public static int n;
    public static int m;
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        nums = new int[][]{
                {9, 1, 1, 0, 7},
                {1, 0, 2, 1, 0},
                {1, 9, 1, 1, 0}};

        n = nums.length;
        m = nums[0].length;
        int ans = Integer.MIN_VALUE;//获取整数的最小值。
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                visited = new int[n][m];
                ans = Math.max(ans,dfs(i,j,""));
            }
        }
        System.out.println(ans);

    }

    public static int dfs(int row,int column,String s){
        if (row < 0 || column < 0 || row >= n || column >= m || visited[row][column] == 1){
            return 0;
        }
        s += Integer.toString(nums[row][column]);
        //追加字符串的方法。String 是final对象，不会被修改，每次使用 + 进行拼接都会创建新的对象，而不是改变原来的对象，也属于线程安全的；
        //编译的时候把“+”号操作符替换成了 StringBuilder 的 append 方法。
        //先有 StringBuffer 后有 StringBuilder，两者就像是孪生双胞胎，该有的都有，只不过大哥 StringBuffer 因为多呼吸两口新鲜空气，所以是线程安全的。
        //StringBuffer 类的 append 方法比 StringBuilder 多了一个关键字 synchronized

        if (s.length()==4){
            return Integer.parseInt(s);
        }

        ArrayList<Integer> list = new ArrayList<>();

        visited[row][column] = 1;//对称；

        for (int[] item:dirs){
            list.add(dfs(row+item[0],column+item[1],s));
        }

        visited[row][column] = 0;//对称；出dfs后要把当前节点复原为未遍历过的状态；

        return Collections.max(list);//获取数组中的最大最小值但是参数必须是List（可变长的）；
    }
}
