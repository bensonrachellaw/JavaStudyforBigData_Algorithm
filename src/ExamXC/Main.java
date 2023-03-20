package ExamXC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    //携程第二题，ans应该用long才能ac；
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] nums = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i<n;i++){
            int tmp = reader.nextInt();
            nums[i] = tmp;
            set.add(tmp);
        }
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        char[] s = reader.nextLine().toCharArray();
        int ans = 0;
        HashMap<Integer,Integer> blue = new HashMap<>();
        HashMap<Integer,Integer> red = new HashMap<>();
        for (int i = 0;i<n;i++){
            if (s[i]=='B'){
                if (blue.containsKey(nums[i])){
                    int add = blue.get(nums[i]);
                    blue.put(nums[i],add+1);
                }
                else {
                    blue.put(nums[i],1);
                }

            }
            else {
                if (red.containsKey(nums[i])){
                    int add = red.get(nums[i]);
                    red.put(nums[i],add+1);
                }
                else {
                    red.put(nums[i],1);
                }

            }
        }
        for (int temp:set){
            ans += red.getOrDefault(temp,0) * blue.getOrDefault(temp,0);
        }

        System.out.println(ans);
    }
}
