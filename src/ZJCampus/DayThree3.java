package ZJCampus;

import java.util.Scanner;

public class DayThree3 {
    /**
     * 图流算法：
     * 最小费用最大流的问题
     * https://www.luogu.com.cn/problem/P6122
     * https://www.luogu.com.cn/blog/command-block/mu-ni-fei-yong-liu-xiao-ji
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        int totalHome = 0; //记录总房间个数
        //记录松鼠走过的距离
        int res = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            totalHome += a[i];
        }

        for (int i = 0; i < m; i++) {
            //松鼠的所在下标
            int index = sc.nextInt();
            //该松鼠占用该位置的容量
            a[index]--;
        }

        //最后剩余房间数, 让多余的房间不要往上走
        int leftHome = totalHome - m;

        //层次遍历，从最后一层开始，每层的松鼠只能往上走
        //如果有多余的房间，我们让房间也往上走
        //每次往上走的时候，增加走过的距离
        //！！关键代码如下：
        for (int i = n; i > 1; i--) {
            if (a[i]!=0) {
                if (leftHome > 0 && a[i] > 0) {
                    if (leftHome > a[i]) {
                        leftHome -= a[i];
                    } else {
                        a[i/2] += (a[i]-leftHome);
                        res += (a[i]-leftHome);
                        a[i] = 0;
                    }
                    continue;
                }
                a[i/2] += a[i];
                res += Math.abs(a[i]);  //每次只往上走一步
                a[i] = 0;
            }
        }
        System.out.println(res);
    }

}
