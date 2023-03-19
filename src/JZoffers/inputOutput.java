package JZoffers;

import java.util.*;

/**
 * 输入：
 * 5
 * c d a bb e
 *
 * 输出：以空格间隔输出，最后没有空格。
 * a bb c d e
 */
public class inputOutput{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] str = new String[num];
        while(sc.hasNextLine()){
            str = sc.nextLine().split(" ");
        }
        Arrays.sort(str);
        System.out.println(String.join(" ",str));
    }
}