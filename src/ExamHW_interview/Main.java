package ExamHW_interview;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,5,9,6,0};
        System.out.println(solution(a));
    }
    public static String solution (int[] arr){
        Arrays.sort(arr);
        String h = "";
        boolean[] vis = new boolean[6];//记录被使用过的数字

        int max1 = 0,max2 = 0, max3 = 0, max4 = 0, max5 = 0, max6 = 0;
        int max1i= -1,max2i = -1, max3i = -1, max4i =-1, max5i = -1, max6i = -1;

        //hour
        for (int i = 0;i<6;i++){
            if (arr[i]<=2){
                if (arr[i]>=max1) {
                    max1 = arr[i];
                    max1i = i;
                }

            }
        }
        if(max1i==-1){
            return "invalid";
        }
        if (max1==1 || max1==0){
            vis[max1i] = true;
            for (int i = 0;i<6;i++){
                if (arr[i]<=9 && !vis[i]){
                    if (arr[i]>=max2) {
                        max2 = arr[i];
                        max2i = i;
                    }
                }
            }
        }
        if (max1==2){
            vis[max1i] = true;
            for (int i = 0;i<6;i++){
                if (arr[i]<=4 && !vis[i]){
                    if (arr[i]>=max2) {
                        max2 = arr[i];
                        max2i = i;
                    }
                }
            }
        }
        if(max2i==-1){
            return "invalid";
        }
        vis[max2i] = true;

        //min
        for (int i = 0;i<6;i++){
            if (arr[i]<=5 && !vis[i]){
                if (arr[i]>=max3) {
                    max3 = arr[i];
                    max3i = i;
                }

            }
        }
        if(max3i==-1){
            return "invalid";
        }
        vis[max3i] = true;
        for (int i = 0;i<6;i++){
            if (arr[i]<=9 && !vis[i]){
                if (arr[i]>=max4) {
                    max4 = arr[i];
                    max4i = i;
                }

            }
        }
        if(max4i==-1){
            return "invalid";
        }
        vis[max4i] = true;

        //second
        for (int i = 0;i<6;i++){
            if (arr[i]<=5 && !vis[i]){
                if (arr[i]>=max5) {
                    max5 = arr[i];
                    max5i = i;
                }

            }
        }
        if(max5i==-1){
            return "invalid";
        }
        vis[max5i] = true;
        for (int i = 0;i<6;i++){
            if (arr[i]<=9 && !vis[i]){
                if (arr[i]>=max6) {
                    max6 = arr[i];
                    max6i = i;
                }

            }
        }
        if(max6i==-1){
            return "invalid";
        }
        vis[max6i] = true;


        StringBuilder s = new StringBuilder();
        s.append(String.valueOf(max1));
        s.append(String.valueOf(max2));
        s.append(":");
        s.append(String.valueOf(max3));
        s.append(String.valueOf(max4));
        s.append(":");
        s.append(String.valueOf(max5));
        s.append(String.valueOf(max6));

        return s.toString();
    }
}