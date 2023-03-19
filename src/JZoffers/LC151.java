package JZoffers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC151 {
    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);//以空格输出可参照此方法。
        }
    }
}
