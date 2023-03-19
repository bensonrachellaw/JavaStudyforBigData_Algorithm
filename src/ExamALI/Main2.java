package ExamALI;

import java.util.Arrays;

public class Main2 {
    //与76. 最小覆盖子串，一个是统计种类，一个是统计数量。还有567. 字符串的排列（字节也考过）
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        String s = "aabba";
        System.out.println(solution(n,k,s));
    }
    public static int solution(int n,int k,String s){
        int[] arr = new int[130];
        char[] c = s.toCharArray();
        int i = 0;
        int j = 0;
        int kind = 0;
        int ans = 0;
        for (char x : c) {
            if (arr[x]==0){
                kind++;
            }
            arr[x]++;
        }
        //i往右走是删减剩余字符的类型，j往右走是增加剩余字符的类型。
        while (i<c.length){
            arr[c[i]]--;
            if (arr[c[i]]==0){
                kind--;
            }
            while (j<=i && kind<k){//不符合条件就j往右走来增加剩余字符的类型。
                arr[c[j]]++;
                if (arr[c[j]]==1){
                    kind++;
                }
                j++;
            }
            ans += i - j + 1;//符合条件的子集，这样做不会算重复了。
            /**
             * 比如有字符串：abcaabbdd 现在正好删去abc是符合king>=k的，那abc的所有子集都是符合条件的。
             * 那abc的所有子集怎么计算呢？首先i是从a不断往后走的，那我们就从i开始不断累加计算abc的所有子集，且不会重复。
             * 比如i==0时，有a ： 0 - 0 + 1；
             *             ab，b ：1 - 0 + 1;(这里很关键，这里为2，是指新的i（1）与前面连起来所有数（包括自己）为左端点的子串的情况，所以是2；
             *             abc,bc,c:2 - 0 + 1
             *             所以就计算了所有的abc的子集。
             */
            i++;
        }
        return ans;
    }
}
