//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 277 👎 0


import sun.font.FontRunIterator;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_409 {
    /**
     * 数组的解法
     * @param s
     * @return
     */
    public int longestPalindrome_1(String s) {
        if (s == null)
            return 0;
        char[] chars = s.toCharArray();
        boolean[] arr = new boolean[58];

        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'A'] = !arr[chars[i] - 'A'];
        }
        int singleCharsCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]){
                singleCharsCount++;
            }
        }
        return singleCharsCount == 0 ? chars.length : chars.length + 1 - singleCharsCount;
    }

    /**
     * 哈希表解法
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        //将字符串中字符出现的次数加入到hashMap中
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int res = 0;
        for (Character key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 0)
                res += map.get(key);  //如果是偶数的话，全部加进去
            else
                res += map.get(key) - 1; // 如果是奇数的话，减一加进去
        }
        return res < s.length() ? res + 1 : res;  //如果没有加完，说明有奇数的存在，可以将奇数放在中间位置
    }
}
//leetcode submit region end(Prohibit modification and deletion)
