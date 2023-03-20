package JZoffers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 课程表 {
    public static void main(String[] args) {

    }

}
class Solution_LC207DFS {
    public ArrayList<ArrayList<Integer>> table;
    public int[] degree;
    public int[] vis;
    public int tag = 0;
    public static HashSet<Integer> set ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        table = new ArrayList<>();
        degree = new int[numCourses];
        vis = new int[numCourses];
        for (int i = 0;i<numCourses;i++){
            table.add(new ArrayList<>());
        }
        //两种建图方式，我的思维已经是[ai, bi]：ai->bi;如果只是判断是否有环的话，其实都无所谓。
        //如果是dfs，vis[]数组有三种状态。同一个节点的所有出度节点之间没有关系，有没有重复都不能判断是否有环。
        for (int[] temp : prerequisites){
            table.get(temp[0]).add(temp[1]);
            degree[temp[1]] += 1;
        }
        for (int i = 0;i<numCourses;i++){
            set = new HashSet<>();
            if (vis[i]==2) continue;//回溯完的，遍历完成的要剪枝
            dfs(i);
            if (tag==1) {
                return false;
            }
        }
        return true;
    }
    public void dfs(int k){
        if (vis[k]==1) {//正在搜索还未回溯的，即遇到环
            tag = 1;
            return;
        }
        vis[k] = 1;
        if (tag==1) return;
        for (int x :table.get(k)){
            if (vis[x]==2) continue;//回溯完的，遍历完成的要剪枝
            if (tag==0){
                dfs(x);
            }
        }
        vis[k] = 2;
    }
}
class Solution_LC207BFS {
    public ArrayList<ArrayList<Integer>> table;
    public int[] degree;
    public int[] vis;
    public int tag = 0;
    public static HashSet<Integer> set ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        table = new ArrayList<>();
        degree = new int[numCourses];
        vis = new int[numCourses];
        for (int i = 0;i<numCourses;i++){
            table.add(new ArrayList<>());
        }
        //两种建图方式，我的思维已经是[ai, bi]：ai->bi;如果只是判断是否有环的话，其实都无所谓。
        //如果是dfs，vis[]数组有三种状态。同一个节点的所有出度节点之间没有关系，有没有重复都不能判断是否有环。
        //如果是bfs,判断所有的入度为0(在过程中变为0的也算)的节点数量等不等于numCourses;
        for (int[] temp : prerequisites){
            table.get(temp[0]).add(temp[1]);
            degree[temp[1]] += 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0;i<numCourses;i++){
            if (degree[i]==0){
                queue.offer(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            cnt++;
            for (int x : table.get(tmp)){
                degree[x]--;
                if (degree[x]==0) {
                    queue.offer(x);
                }
            }
        }
        if (cnt==numCourses) return true;
        return false;
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
    }
}
