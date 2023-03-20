package ExamTX;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(getNumber(a));
//        System.out.println();
    }
    public static int getNumber (int[] a) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        s.append("x");
        list.add(-1);
        for (int i : a){
            list.add(i);
        }
        int cnt = a.length;
        while (cnt>1){
            int m = list.size();
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(-1);
            for (int i = 1;i<m;i++){
//                System.out.println(i);
                if (!re(i)){

                    cnt--;
//                    System.out.println(i);
                }
                else {
                    list1.add(list.get(i));
                }
            }
            list = new ArrayList<>(list1);
//            for (int i= 0;i<list1.size();i++){
////                System.out.println(list1.get(i));
//
//            }

        }
        return list.get(1);
    }
    public static boolean re (int n){
        if (n==1) return false;
        if (n==2) return true;
        if (n==3) return true;
        for (int i = 2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
