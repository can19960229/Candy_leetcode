//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 478 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }

    private boolean kmp(String pattern) {

        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail,-1);
        for (int i = 1; i < n; i++) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)){
                j = fail[j];
            }
            if (pattern.charAt(j +1) == pattern.charAt(i)){
                fail[i] = j +1;
            }
        }
        return fail[n - 1] != - 1 && n % (n - fail[n - 1] - 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
