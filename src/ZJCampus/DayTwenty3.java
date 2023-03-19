package ZJCampus;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DayTwenty3 {
    public static void main(String[] args) {
        FastScanner reader = new FastScanner();
        int k = reader.nextInt();
        int n = reader.nextInt();
        int[] teas = new int[n];
        int l = -1;
        int r = n+1;
        for (int i = 0;i<n;i++) {
            teas[i] = reader.nextInt();
            r += teas[i];
        }
        while (l+1<r) {
            int mid = (l+r) >> 1;
            if (check(mid,teas,k)) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        System.out.println(r);
    }
    private static boolean check(int time,int[] teas,int k){
        //模拟派送过程，每个人然后每个区间。
        int[] nums = Arrays.copyOfRange(teas, 0, teas.length);
        for (int i = 0;i<k;i++){
            int t = time;
            for (int j = 0;j<nums.length;j++) {
                t--;//走的时间（移动时间）, 往前移动一步
                if (t<=0) {
                    break;//因为移动导致当前这个人的时间用完
                }
                if (nums[j]>=t){
                    nums[j] = nums[j] - t;
                    break;//因为分发茶水当前这个人的时间用完
                }
                else {
                    t = t -nums[j];
                    nums[j] = 0;
                }
            }
        }
        boolean isDone = true;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]!=0) {
                isDone = false;
            }
        }
        return isDone;
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
