//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
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
// 👍 22 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 主要是两个部分：
     *
     * 1、如何判断变位词？
     * 对字符串进行排序，将字符按照azAZ的顺序排列。
     *
     * 2、如何归类变位词？
     * 使用散列表，将变位词放到同一个列表中。
     * 最后转化为列表返回即可。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //新建hash表，对变位词统计到一起
        HashMap<String , LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        //逐个访问字符串，归入同类变位词，不存在则新增
        for (String s : strs) {
            String key = sortChar(s);
            if (!map.containsKey(key)){
                map.put(key,new LinkedList<>());
            }
            LinkedList<String> tmp = map.get(key);
            tmp.push(s);
        }
        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String sortChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
