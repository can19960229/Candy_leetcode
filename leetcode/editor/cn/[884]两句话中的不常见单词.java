//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。） 
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。 
//
// 返回所有不常用单词的列表。 
//
// 您可以按任何顺序返回列表。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 200 
// 0 <= B.length <= 200 
// A 和 B 都只包含空格和小写字母。 
// 
// Related Topics 哈希表 
// 👍 79 👎 0


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_884 {
    /**
     * 计数法：
     * 每个不常见的单词总共只出现一次。我们可以统计每个单词的出现次数，然后返回恰好出现一次的单词。
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : A.split(" ")) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        for (String word : B.split(" ")) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        List<String> ans = new LinkedList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1){
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
