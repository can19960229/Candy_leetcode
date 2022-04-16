//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 25 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_01_02 {
    public boolean CheckPermutation_1(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        //两个数组的长度要一致
        if (c1.length != c2.length){
            return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);

        System.out.println(c1);
        System.out.println(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation_2(String s1, String s2) {
        //s1和s2的长度首先需要是一致的
        if (s1.length() != s2.length())return false;
        //创建一个长度为26的数组，index值表示的是字符，
        // 元素值表示的是该字符在s1中出现的次数和s2中出现的次数的差值
        int[] nums = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            nums[s1.charAt(i) - 97]++;
            nums[s2.charAt(i) - 97]--;
        }
        //遍历数组，如果元素值不等于0，
        // 说明当前字符在s1中出现的次数和在s2中出现的次数不一致，即返回false
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
