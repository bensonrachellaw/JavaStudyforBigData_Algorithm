package ExamXC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    //携程第三题：给你一串字符串，里面只包含 '0' 和 '1'（两者数目相差不超过 1），现在通过相邻两两交换让 '1' 和 ’0‘ 字符两两交叉排列变成01交叉字符串，问最少的交换次数；
    //贪心算法:思路：因为结果是固定的：
    //如果1的数量比0的数量多1，因此这种情况的结果字符串是1开头1结尾然后10交叉排，以1来遍历。
    //如果0的数量比1的数量多1，就跟前一种情况相反，以0来遍历。
    //如果两者相等，则说明字符串长度为偶数，就以0遍历一遍，再以1遍历一遍然后取最小值。
    //遍历过程，让原来字符串对应位置和结果字符串（下标隔二就相同，因为交叉）的相对应位置的距离就是贡献。因此需要记录每个0和1在原字符串的位置（下标）
    //然后将所有贡献相加就是答案。
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        char[] c = s.toCharArray();
        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        for (int i = 0;i<c.length;i++){
            if (c[i]=='0') zero.add(i);
            else one.add(i);
        }
        long ans = 0;
        int a = zero.size();
        int b = one.size();
        int size = s.length();
        if (a>b){
            int res = 0;
            int i = 0;
            while (res<size && i<a) {
                ans += Math.abs(res-zero.get(i));
                res += 2;
                i++;
            }
        }
        else if (b>a){
            int res = 0;
            int i = 0;
            while (res<size && i<b) {
                ans += Math.abs(res-one.get(i));
                res += 2;
                i++;
            }
        }
        else {
            int ans0 = 0;
            int ans1 = 0;
            int res = 0;
            int i = 0;
            while (res<size && i<a) {
                ans0 += Math.abs(res-zero.get(i));
                res += 2;
                i++;
            }
//            System.out.println(ans0);
            res = 0;
            i = 0;
            while (res<size && i<b) {
                ans1 += Math.abs(res-one.get(i));
                res += 2;
                i++;
            }
//            System.out.println(ans1);
            ans = Math.min(ans0,ans1);
        }
        System.out.println(ans);
    }

}
