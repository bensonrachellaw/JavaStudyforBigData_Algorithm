package ABC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/11/8
 */
public class CountingArrays {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i  = 0;i<n;i++){
            int l = reader.nextInt();
            ArrayList<Integer> adj = new ArrayList<>();
            for (int j = 0;j<l;j++){
                adj.add(reader.nextInt());
            }

            set.add(adj);
        }

        System.out.println(set.size());
    }
}
