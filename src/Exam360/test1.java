package Exam360;
import java.io.*;
import java.util.*;
public class test1 {
    //“老师捞我”：求最大可以及格人数。
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int p = reader.nextInt();
        int q = reader.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0 ; i<n ; i++){
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);//升序排序
        Arrays.sort(arr,Collections.reverseOrder());//int数组逆序排序。首先数组要用Integer不能用int；
        int cnt = 0;
        int pingshi = 100;
        for (int i = n-1;i>=0;i--){
            if (i<n-1 && !arr[i].equals(arr[i + 1])){
                pingshi--;
            }
            double res = (pingshi*p+arr[i]*q)/100;
            if (res >= 60){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
