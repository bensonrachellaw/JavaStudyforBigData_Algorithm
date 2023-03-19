package ExamQNR_QZ;

import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/7
 * 快速幂求余
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println(Decrypt(4296,1601,4757));
    }
    public static int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        int mod = number;
        int num = decryption;
        long base = encryptedNumber;
        long res = 1;
        while(num>0) {
            if (num % 2==1) res = res * base % mod;
            base = base * base % mod;
            num = num / 2;
        }
        return (int)(res % mod);
    }
}
