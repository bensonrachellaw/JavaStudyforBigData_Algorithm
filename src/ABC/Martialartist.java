package ABC;


import java.util.*;
import java.io.*;

/**
 * Description: dp_problems_java_version
 * Created by L6BD610_Luo on 2021/11/8
 */
public class Martialartist {
    static long cnt = 0;
    static int N = 2*(int)1e5;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] T = new int[N+1];
    static int[] K = new int[N+1];
    static boolean[] tag = new boolean[N+1];


    public static void dfs(int n){
        if (!tag[n]){
            cnt += T[n];
            tag[n] = true;
            for (int a: adj.get(n)){
                dfs(a);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner reader = new FastScanner();
        int n = reader.nextInt();
        for(int i = 0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1 ; i<=n ; i++) {
            T[i] = reader.nextInt();
            K[i] = reader.nextInt();
            for (int j = 0; j < K[i]; j++) {
                adj.get(i).add(reader.nextInt());
            }
        }

        Arrays.fill(tag, false);
        dfs(n);
        System.out.println(cnt);

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
