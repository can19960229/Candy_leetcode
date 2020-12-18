//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 427 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        //对p串的每个字符进行hash计数
        int pLength = p.length();
        int sLength = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < pLength; i++) {
            counts[p.charAt(i) - 'a']++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        //从下标为0开始遍历字符串s，对于每个下标，判断接下来长度为pLength的子串是否为目标串的字母异位词
        for (int i = 0; i <= sLength - pLength; i++) {
            //判断过程为临时拷贝一份新的技术数组
            int[] tempCounts = Arrays.copyOf(counts,26);
            int j = i;
            //内部每次遍历p的长度个数的子串，把子串中每个字符的计数器减一，出现负数则进入下个子串的统计
            for(;j < sLength && j < pLength + i;j++){
                if (--tempCounts[s.charAt(j) - 'a'] < 0){
                    break;
                }
            }
            if (j >= pLength + i){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
