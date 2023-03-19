package Exam4399_QZ;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        int n = reader.nextInt();
        char[][] num = new char[s.length()][n];
        int l = s.length();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i<l;i = i + n - 2 + 1 ) {
            set.add(i);
        }
        int tag = 0,x = 0,tag1 = n-2,tag3 = 0;
        // System.out.println(l);
        while (x<l) {
            tag3++;
            if (set.contains(tag)) {
                for (int i = 0;i<n;i++) {

                    if (x==l) {
                        num[tag][i] = ' ';
                    }
                    else{
                        num[tag][i] = s.charAt(x);
                        x++;
                    }
                }
            }
            else {

                for (int i = 0;i<n;i++) {
                    if (i==tag1) {
                        num[tag][i] = s.charAt(x);
                        x++;
                    }
                    else{
                        num[tag][i] = ' ';

                    }

                }
                tag1--;
                if(tag1==0) tag1 = n-2;

            }
            tag++;
        }
        for (int i = 0;i<tag3;i++) {
            System.out.println(Arrays.toString(num[i]));
        }
    }

}
