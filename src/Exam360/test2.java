package Exam360;
import java.io.*;
import java.util.*;
public class test2 {
    //判断是否符合主谓宾结构，这题的输入很考人。
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n1 = reader.nextInt();
        int n2 = reader.nextInt();
        int n3 = reader.nextInt();

        HashSet<String> n1_set = new HashSet<>();
        HashSet<String> n2_set = new HashSet<>();
        HashSet<String> n3_set = new HashSet<>();

        for (int i = 0;i<n1;i++){
            n1_set.add(reader.next());
        }
        for (int i = 0;i<n2;i++){
            n2_set.add(reader.next());
        }
        for (int i = 0;i<n3;i++){
            n3_set.add(reader.next());
        }
        int m = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        String[] res = new String[m];

        for (int i = 0;i<m;i++){
            String[] ans = reader.nextLine().split(" ");
            if (!n1_set.contains(ans[0])){
                res[i] = "NO";
                continue;
            }
            else {
                if (!n2_set.contains(ans[ans.length-1])&&!n3_set.contains(ans[ans.length-1])){
                    res[i] = "NO";
                    continue;
                }
            }
            int a = 0;
            int b = 0;
            int c = 0;
            int tag = 0;
            for (String s :ans){
                if (n2_set.contains(s)){
                    b++;
                    if (c!=0) tag=1;
                }
                if (n1_set.contains(s)){
                    a++;
                }
                if (n3_set.contains(s)){
                    c++;
                }

            }
            if (tag==1){
                res[i] = "NO";
            }
            else if (b!=1) {
                res[i] = "NO";
            }
            else {
                res[i] = "YES";
            }
        }
        for (int i = 0;i<m;i++){
            System.out.println(res[i]);
        }
    }
}
