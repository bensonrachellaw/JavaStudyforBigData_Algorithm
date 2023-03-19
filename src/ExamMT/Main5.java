package ExamMT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] ac = new int[n+1];
        int[] w = new int[n+1];
        for (int i = 2;i<=n;i++){
            ac[i] = reader.nextInt();
        }
        for (int i = 1;i<=n;i++){
            w[i] = reader.nextInt();
        }
        int m = reader.nextInt();
        int[] q = new int[m];
        int[] st = new int[m];
        int[] ed = new int[m];
        for (int i = 0;i<m;i++){
            st[i] = reader.nextInt();
        }
        for (int i = 0;i<m;i++){
            ed[i] = reader.nextInt();
        }
        int[] res = new int[m];
        for (int i = 0;i<m;i++){
            HashSet<Integer> x = solution(ac,st[i],ed[i]);
            int ans = re(x);
            res[i] = ans;
        }
        for (int i = 0;i<m;i++){
            if (i==m-1) {//以空格分隔输出
                System.out.print(res[i]);
            }
            else{
                System.out.print(res[i]+" ");
            }
        }


    }

    public static HashSet<Integer> solution(int[] ac, int st, int ed){
        int l = st;
        int r = ed;
        HashSet<Integer> a = new HashSet<>();
        ArrayList<Integer> b = new ArrayList<>();
        while (ed!=1){
            a.add(ed);
            ed = ac[ed];
        }
        a.add(1);
        int xx = 1;
        while (st!=1){
            if (a.contains(st)) {
                xx = st;
                break;
            }
            b.add(st);
            st = ac[st];

        }
        b.add(1);
        HashSet<Integer> c = new HashSet<>();
        while (l!=xx){
            c.add(l);
            l = ac[l];
        }
        while (r!=xx){
            c.add(r);
            r = ac[r];
        }
        c.add(xx);
        return c;
    }
    public static int re(HashSet<Integer> s){
        int ans = 0;
        for (int i :s){
            ans = ans ^ i;
        }
        return ans;
    }
    /**
     * 你学会了一种奇怪的运算，叫做异或（对应于C/C++中 ‘^’代表的运算）。你对这个运算很好奇，你把他拿到一棵树上进行摆玩。
     *
     * 这棵树上每个节点都有权值，你每次指定两个节点，想要知道这两个节点的简单路径(即此路径上的节点不重复)上的所有点的值异或起来是多少。
     *
     *
     *
     * 输入描述
     * 第一行一个正整数n表示节点个数。
     *
     * 第二行n-1个正整数p[2,3,…n], p[i]表示第 i 个节点的父亲。1号节点是根节点。
     *
     * 第三行n个正整数c[1,2,…n]，c[i]表示第 i 个节点的权值。
     *
     * 第四行一个正整数m表示询问次数。
     *
     * 第五行m个正整数u[1,2,…m]，u[i]表示第 i 次询问中指定的第一个点。
     *
     * 第六行m个正整数v[1,2,…m]，v[i]表示第 i 次询问中指定的第二个点。
     *
     * 数据保证形成合法的树。数字间两两有空格隔开。
     *
     * n,m<=50000
     *
     * c[i]<=1000000000，1<=u[i],v[i]<=n
     *
     * 输出描述
     * 输出一行m个空格隔开的整数，依次对应每次询问的答案。
     *
     *
     * 样例输入
     * 3
     * 1 1
     * 1 2 3
     * 3
     * 1 1 2
     * 2 3 3
     * 样例输出
     * 3 2 0
     *
     * 提示
     * 样例如图所示
     *
     * 第一次询问，1到2的路径上有节点1、2，那么答案为1^2=3
     *
     * 第二次询问，1到3的路径上有节点1、3，那么答案为1^3=2
     *
     * 第三次询问，2到3的路径上有节点1、2、3，那么答案为1^2^3=0
     */

}
