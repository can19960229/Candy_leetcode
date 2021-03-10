//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1006 👎 0


import java.util.HashMap;
import java.util.Map;

/*
先右指针right遍历字符串s，在s中找到有t中所有字母的子串（也就是滑动窗口）
然后开始缩小滑窗，左指针left右移，去掉可以去掉的字母，记录这个子串（滑窗）的最小长度
右指针right继续遍历，不断更新滑窗最小长度
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_76 {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m) return "";

        Map<Character, Integer> need = new HashMap<Character, Integer>();
        for(int i = 0; i < m; i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[]{0, n};
        int left = 0, needCnt = m;
        for(int right = 0; right < n; right++){
            char cR = s.charAt(right);
            if(need.getOrDefault(cR, 0) > 0){
                needCnt--;
            }
            need.put(cR, need.getOrDefault(cR, 0) - 1);
            if(needCnt == 0){
                while(true){
                    char cL = s.charAt(left);
                    if(need.get(cL) == 0){
                        break;
                    }
                    need.put(cL, need.get(cL) + 1);
                    left++;
                }
                if(right - left < res[1] - res[0]){
                    res[0] = left;
                    res[1] = right;
                }
            }
        }
        return res[0] != 0 || res[1] != n ? s.substring(res[0], res[1] + 1) : "";
    }
}

//leetcode submit region end(Prohibit modification and deletion)
