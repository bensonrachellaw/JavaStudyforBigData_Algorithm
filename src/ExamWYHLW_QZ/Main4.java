package ExamWYHLW_QZ;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main4 {
    static Random random = new Random();
    public static void main(String[] args) {
        FastScanner reader = new FastScanner();
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = reader.nextInt();
        }
        int ans = 0;
        for (int j = 1;j<n-1;j++) {
            int[] tmp = Arrays.copyOf(a,a.length);
            quicksort(tmp,0,j-1);
            quicksort(tmp,j+1,a.length-1);
            int l = j-1,r = n-1;
            if (a[j]>=tmp[l] && a[j]>=tmp[r]) {
                continue;
            }
            int i = j-1;
            while (i>=0 && tmp[i]>a[j]) {
                int k = n-1;
                while (k>=j+1 && tmp[k]>a[j]){
                    if (tmp[i]==tmp[k] && tmp[i] > a[j]){
                        ans++;
//                        System.out.println(a[j]);
                    }
                    k--;
                }
                i--;
            }
        }
        System.out.println(ans);
    }
    public static void quicksort(int[] nums,int l,int r){
        if (l>=r) return;
        int pivot = random.nextInt(r-l+1)+l;//左闭右开的。先在l-r范围随机选一个数。

        swap(nums,pivot,l);//交换这个数到数组最前面。

        int i = l;
        for (int j = i+1;j<=r;j++){
            if (nums[j]<nums[l]){
                i++;
                swap(nums,j,i);
            }
        }
        swap(nums,l,i);//这里将当次的pivot的数放到它正确的位置上。

        quicksort(nums,l,i-1);
        quicksort(nums,i+1,r);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
