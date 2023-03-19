package ExamMT_QZ3;

import java.util.*;
public class Main5 {
    //填充火箭漏洞。
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        for (int i = 0;i<m;i++) {
            b[i] = reader.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        //双指针做法。模拟！！！
        int ans = 0;
        int pa = 0,pb = 0;//分别指向数组当前的最小元素。a数组中比pb指向元素小的都用pb指向的元素来填充。也就是每个a数组的元素都用b数组中大于自己的最小元素填充。
        while (pa<n&&pb<m){
            if (b[pb]>=a[pa]) {
                ans+=b[pb];
                pa++;
            }
            else {
                pb++;
            }
        }
        if (pb==m && pa < n) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }
}