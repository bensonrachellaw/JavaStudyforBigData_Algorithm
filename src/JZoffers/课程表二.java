package JZoffers;

import java.util.ArrayList;
import java.util.HashSet;

public class 课程表二 {
    public static void main(String[] args) {

    }
}
class LC210 {
    public ArrayList<ArrayList<Integer>> table;
    public int[] degree;
    public int[] vis;
    public int tag = 0;
    public int index = 0;
    public int[] ans;//需要输出顺序，不止判断有没有环。
    public static HashSet<Integer> set ;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        table = new ArrayList<>();
        degree = new int[numCourses];
        vis = new int[numCourses];
        ans = new int[numCourses];
        for (int i = 0;i<numCourses;i++){
            table.add(new ArrayList<>());
        }
        //两种建图方式，我的思维已经是[ai, bi]：ai->bi;如果只是判断是否有环的话，其实都无所谓。
        //如果像华为机试那题需要输出指定某个点的路径的，使用dfs,且要使用[ai, bi]：ai->bi式建图。
        for (int[] temp : prerequisites){
            table.get(temp[0]).add(temp[1]);
            degree[temp[1]] += 1;
        }
        for (int i = 0;i<numCourses;i++){
            set = new HashSet<>();
            if (vis[i]==2) continue;
            dfs(i);
            if (tag==1) {
                return new int[0];
            }
        }
        //dfs(99);//华为机试：输出指定某个点的路径的
        return ans;
    }
    public void dfs(int k){
        if (vis[k]==1) {
            tag = 1;
            return;
        }
        vis[k] = 1;
        if (tag==1) return;
        for (int x :table.get(k)){
            if (vis[x]==2) continue;
            if (tag==0){
                dfs(x);
            }
        }
        vis[k] = 2;
        ans[index++] = k;
    }
}