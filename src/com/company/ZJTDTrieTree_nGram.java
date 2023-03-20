package com.company;

import java.util.*;

public class ZJTDTrieTree_nGram {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m =  reader.nextInt();
        int k = reader.nextInt();
        String x = reader.nextLine();//吃掉回车。这里的bug真烦人啊。
        Trie trie = new Trie();
        for (int i = 0;i<n;i++){
            String[] words = reader.nextLine().split(" ");
            trie.insert(words);
        }
        for (int i = 0;i<m;i++){
            String[] prefixes = reader.nextLine().split(" ");
            HashMap<String,Integer> rank = new HashMap<>();
            Trie nextWord = trie.query(prefixes);
            if (nextWord.children.isEmpty()){
                System.out.println("");
            }
            else {
                for (String s:nextWord.children.keySet()){
                    /*
                    把trie返回之后，获取所有的键（也就是词）和对应的词频。trie的当前HashMap的键存了nextWord的词，而每个键的值对应着下一个trie，而这个trie的cnt才是词频。
                     */
                    rank.put(s,nextWord.children.get(s).cnt);
                }

                //输出部分（按值降序再按键升序）如果调用compare方法大于0，就把前一个数和后一个数交换，也就是把大的数放后面了，即所谓的 升序了
                ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(rank.entrySet());

                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        int a = o2.getValue().compareTo(o1.getValue());//compareTo调用compare
                        if (a==0){
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        else {
                            return a;
                        }
                    }
                });

                for (int j = 0;j<Math.min(list.size(),k);j++){
                    System.out.print(list.get(j).getKey()+" ");
                }
            }
        }


    }

    /**
     * 与字节模拟笔试第四题一样，只是query需要返回<节点trie>类型。
     */
    static class Trie{
        private HashMap<String,Trie> children;
        private int cnt;

        public Trie(){
            children = new HashMap<>();
            cnt = 0;
        }

        public void insert(String[] arr){
            Trie node = this;
            for (String s : arr){
                if (! node.children.containsKey(s)){
                    node.children.put(s,new Trie());
                }
                node = node.children.get(s);
                node.cnt++;
            }

        }

        public Trie query(String[] arr){
            Trie node = this;
            for (String s : arr){
                if (! node.children.containsKey(s)){
                    return new Trie();
                }
                node = node.children.get(s);
            }
            return node;
        }

    }
}
