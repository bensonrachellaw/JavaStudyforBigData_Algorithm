package ExamWY;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.*;

public class Main2 {
    //01背包问题：
    public static void main(String[] args) {
        FastScanner reader = new FastScanner();
        int n = reader.nextInt();
        for (int i = 0;i<n;i++) {
            int num = reader.nextInt();
            int[][] arr = new int[num][3];
            for (int j = 0;j<num;j++) {
                arr[j][0] = reader.nextInt();
                arr[j][1] = reader.nextInt();
                arr[j][2] = reader.nextInt();
            }
            int ans = re(arr);
            if (ans==-1){
                System.out.println("TAT");
            }
            else {
                System.out.println(ans);
            }
        }
    }
    //01背包问题：
    public static int re(int[][] arr) {
        int max = -1;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        List<int[]> list3 = new ArrayList<>();
        List<int[]> list4 = new ArrayList<>();
        List<int[]> list5 = new ArrayList<>();
        List<int[]> list6 = new ArrayList<>();
        for (int[] xx : arr){
           if (xx[0]==1){
               list1.add(new int[]{xx[1],xx[2]});
           }
           else if(xx[0]==2){
               list2.add(new int[]{xx[1],xx[2]});
           }
           else if(xx[0]==3){
               list3.add(new int[]{xx[1],xx[2]});
           }
           else if(xx[0]==4){
               list4.add(new int[]{xx[1],xx[2]});
           }
           else if(xx[0]==5){
               list5.add(new int[]{xx[1],xx[2]});
           }
           else if(xx[0]==6){
               list6.add(new int[]{xx[1],xx[2]});
           }
        }
        if (list1.size()>10 || list2.size()>10 || list3.size()>10|| list4.size()>10|| list5.size()>10|| list6.size()>10) {
            int max1 = -1;
            int sum1 = 0;
            for (int i = 0;i<list1.size();i++){
                if (list1.get(i)[1]>max1){
                    max1 = Math.max(list1.get(i)[1],max1);
                    sum1 = list1.get(i)[0];
                }
            }
            int max2 = -1;
            int sum2 = 0;
            for (int i = 0;i<list2.size();i++){
                if (list2.get(i)[1]>max2){
                    max2 = Math.max(list2.get(i)[1],max2);
                    sum2 = list2.get(i)[0];
                }
            }
            int max3 = -1;
            int sum3 = 0;
            for (int i = 0;i<list3.size();i++){
                if (list3.get(i)[1]>max3){
                    max3 = Math.max(list3.get(i)[1],max3);
                    sum3 = list3.get(i)[0];
                }
            }
            int max4 = -1;
            int sum4 = 0;
            for (int i = 0;i<list4.size();i++){
                if (list4.get(i)[1]>max4){
                    max4 = Math.max(list4.get(i)[1],max4);
                    sum4 = list4.get(i)[0];
                }
            }
            int max5 = -1;
            int sum5 = 0;
            for (int i = 0;i<list5.size();i++){
                if (list5.get(i)[1]>max5){
                    max5 = Math.max(list5.get(i)[1],max5);
                    sum5 = list5.get(i)[0];
                }
            }
            int max6 = -1;
            int sum6 = 0;
            for (int i = 0;i<list6.size();i++){
                if (list6.get(i)[1]>max6){
                    max6 = Math.max(list6.get(i)[1],max6);
                    sum6 = list6.get(i)[0];
                }
            }
            if (sum1+sum2+sum3+sum4+sum5+sum6>=100) {
                max = max1 + max2 + max3 + max4 + max5 + max6;
            }
            else max = -1;
        }
        else {
            for (int i = 0;i<list1.size();i++){
                for (int j = 0;j<list2.size();j++){
                    for (int k = 0;k<list3.size();k++){
                        for (int l = 0;l<list4.size();l++){
                            for (int m = 0;m<list5.size();m++){
                                for (int n = 0;n<list6.size();n++){
                                    if (list1.get(i)[0]+list2.get(j)[0]+list3.get(k)[0]+list4.get(l)[0]+list5.get(m)[0]+list6.get(n)[0] >=100){
                                        max = Math.max(max,list1.get(i)[1]+list2.get(j)[1]+list3.get(k)[1]+list4.get(l)[1]+list5.get(m)[1]+list6.get(n)[1]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //70%
        if (max==-1) return -1;
        return max;
    }
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
    }
}
