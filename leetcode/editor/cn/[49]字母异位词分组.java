//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 499 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List> list = new HashMap<String, List>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);//把将 char 数组 chars 转换成字符串
            if (!list.containsKey(key))
                list.put(key,new ArrayList());
            list.get(key).add(str);
        }
        return new ArrayList<>(list.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
