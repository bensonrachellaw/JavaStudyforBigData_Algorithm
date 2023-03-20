package com.company;

import java.util.*;


public class TrieTree {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Trie trie = new Trie();

        int n = reader.nextInt();
        int m = reader.nextInt();

        for (int i = 0 ; i < n ; i++){
            String s = reader.next();
            trie.insert(s);
        }

        for (int i = 0 ; i < m ; i++){
            String s = reader.next();
            int ans = trie.query(s);
            System.out.println(ans);
        }

    }

    /**
     * 一次建树，多次查询。插入是线性的，查询是线性的，O（n）时间复杂度。
     */
    static class Trie {
        private Trie[] children;
        private int cnt;//这里改为计数。

        public Trie() {
            children = new Trie[26];
            cnt = 0;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.cnt++;
        }

        public int query(String prefix) {
            Trie node = this;
            int ans = 0;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    break;
                }
                ans = ans + node.cnt;
                node = node.children[index];

            }
            if(node != null){
                ans = ans + node.cnt;
            }
            return ans;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }
}
