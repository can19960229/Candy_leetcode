//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5056 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_3 {

    /**
     * 我自己写的题解，感觉有点像暴力递归，没错，就是暴力
     * 当出现了重复的字符时，需要对一开始出现重复的字符的位置进行判断，而不是直接break，这样会增大复杂度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        if (s.length() == 0){
            return 0;
        }

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> temp = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (temp.contains(s.charAt(j))){    //这里只是简单的判断是否重复，并对i进行加一，应该判断出现重复的字符的位置,因为set是无序的，则需要使用map进行存储
                    //判断如果包含了，则直接跳出
                    break;

                }
                temp.add(s.charAt(j));
            }
            System.out.println(temp);
            //遍历出现的temp的长度中的最大值
            max = Math.max(max,temp.size());
        }
        return max;
    }

    /**
     * 力扣给出的官方题解
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring_2(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> temp = new HashSet<>();
        int n = s.length();
        //右指针，初始值为-1，相当于在字符串的左边界的左侧，还么有开始移动
        int rk = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0){
                //左指针向右移动一格，移除一个字符
                temp.remove(s.charAt(i - 1));
//                System.out.println(temp);
            }
            while (rk + 1 < n && !temp.contains(s.charAt(rk +1))){
                //不断移动右指针
                temp.add(s.charAt(rk + 1));
                System.out.println(temp);
                rk ++;
            }
            //第i到rk个字符是一个极长的无重复字符子串
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring_3(String s) {
        int n = s.length(),ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end = 0,start = 0;end < n;end ++){
            char temp = s.charAt(end);
            if (map.containsKey(temp)){
                start = Math.max(map.get(temp),start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(s.charAt(end),end + 1);
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
