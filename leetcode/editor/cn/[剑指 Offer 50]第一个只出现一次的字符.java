//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 73 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_50_1 {
    public char firstUniqChar_1(String s) {
        char[] chars = s.toCharArray();

        HashMap<Character,Integer> ss = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            ss.put(chars[i],ss.getOrDefault(chars[i],0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (ss.get(chars[i]) == 1){
                return chars[i];
            }
        }
        return  ' ';
    }

    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c,!dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c))
                return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
