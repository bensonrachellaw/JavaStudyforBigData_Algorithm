package com.company;


import java.util.HashMap;
import java.util.Scanner;

public class ZJTDTrieTree {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        Trie trie = new Trie();
        for (int i = 0;i<n;i++){
            long l = reader.nextLong();
            long[] t1 = new long[(int) l];
            for (int j = 0;j<l;j++){
                t1[j] = reader.nextLong();
            }
            long[] t2 = new long[(int) l - 1];
            for (int j = 1;j<l;j++){
                t2[j-1] = t1[j] - t1[j-1];
            }
            trie.insert(t2);
        }
        for (int i = 0;i<m;i++){
            long l = reader.nextLong();
            long[] t1 = new long[(int) l];
            for (int j = 0;j<l;j++){
                t1[j] = reader.nextLong();
            }
            long[] t2 = new long[(int) l - 1];
            for (int j = 1;j<l;j++){
                t2[j-1] = t1[j] - t1[j-1];
            }
            long ans = trie.query(t2);
            System.out.println(ans);
        }

    }

    static class Trie {
        private HashMap<Long,Trie> children;
        private int cnt;

        public Trie(){
            children = new HashMap<>();
            cnt = 0;
        }

        public void insert(long[] arr){
            Trie node = this;
            for (long item:arr){
                if (! node.children.containsKey(item)){
                    node.children.put(item,new Trie());
                }
                node = node.children.get(item);
                node.cnt++;
            }
        }

        public Long query(long[] arr){
            Trie node = this;
            long ans = 0;
            int i;
            for (i = 0; i < arr.length; i++){
                if (! node.children.containsKey(arr[i])){
                    break;
                }
                node = node.children.get(arr[i]);
            }
            if (i==arr.length){
                ans = node.cnt;
            }
            return ans;
        }

    }

}
