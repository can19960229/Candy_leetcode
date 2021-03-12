//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 10 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1668 {
    public int maxRepeating(String sequence, String word) {
        /*

        //该代码没有考虑是连续重复，而找出了子字符串的数量
        if (word.length() > sequence.length()) return 0;
        char[] s = sequence.toCharArray();
        char[] w = word.toCharArray();
        int count = 0;
        int left = 0,right = w.length - 1;
        while (right <= s.length-1){
            //对比窗口中的值是否和w中的值是一样的
            //把窗口的字符数组转换成字符串，对比和word的是字符串是否相等
            String str = sequence.substring(left,right + 1);

            if (str.equals(word)){
                count++;
                System.out.println(str);
            }
            //窗口持续向右移动
            left ++;
            right++;
        }
        return count;

         */

        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb)) {
            count++;
            sb.append(word);
            System.out.println(sb);
        }
        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
