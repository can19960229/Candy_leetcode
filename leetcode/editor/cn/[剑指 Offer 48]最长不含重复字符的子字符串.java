//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 154 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_48_1 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))){
                //如果是相同的字符，则把字符的子串开头移到遍历的位置
                i = Math.max(i,dic.get(s.charAt(j))); //更新左指针 i
            }
            //把得到的没有重复的字符加入到map集合中
            dic.put(s.charAt(j),j); //哈希表记录
            //计算最长的子串长度
            res = Math.max(res,j - i); //更新结果
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
