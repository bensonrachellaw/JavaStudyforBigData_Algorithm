package ExamSCSJ_QZ;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            if (s.charAt(0)=='0' || s.charAt(0)=='.' || s.charAt(s.length()-1)=='.') {
                System.out.println(-1);
            }
            else {
                System.out.println(ip(s));

            }
        }
    }
    public static long ip(String s) {
        for (int i = 0;i<s.length();i++){
            if (!Character.isDigit(s.charAt(i))) {
                if (s.charAt(i)!='.') {
                    return -1;
                }
            }
        }
        String[] ss = s.split("\\.");
        for (int i = 0;i< ss.length;i++) {
            if (Objects.equals(ss[i], "")) {
                ss[i]="0";
            }
            else if (Integer.parseInt(ss[i])>=256){
                return -1;
            }
        }
        long ans = 0;
        for (int i = 0;i< ss.length;i++) {
            int power = 6 - i;
            long ip = Integer.parseInt(ss[i]);
            ans+=ip*Math.pow(256,power);
        }
        return ans;
    }

}
