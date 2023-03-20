package JZoffers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/13
 * LC49《字母异位词分组》
 */
public class LC49 {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // Java8中的Stream API，Stream不是集合元素，它不是数据结构并不保存数据，它更像一个高级版本的Iterator
                    // 高级版本的Stream，用户只要给出需要对其包含的元素执行什么操作，比如，“过滤掉长度大于 10 的字符串”、“获取每个字符串的首字母”等，Stream会隐式地在内部进行遍历，做出相应的数据转换。
                    // Stream可以并行化操作，数据会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出。然而迭代器只能命令式地、串行化操作。
                    // Stream 的另外一大特点是，数据源本身可以是无限的。
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    //注意 groupingBy 算子计算完以后，返回的是一个 Map<String, List<String>>，map 的键是每种排序后的字符串，值是聚合的原始字符串，我们只关心值，所以我们最后 new ArrayList<>(map.values())
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }
    //思路：用每个字符串按字典序排序后的字符串作为key，如果是异位关系，他们肯定对应同一个key。
    // 因为异位字符串之间只是字母的顺序不同。因此将每个字符串加到key为排序后的字符串的map的对应的value中，最后再把map全部的value拿出来放进ArrayList里。
    public  List<List<String>> groupAnagrams1(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
