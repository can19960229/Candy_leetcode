//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。 
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。 
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。 
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// 所有字符串中都仅包含小写英文字母 
// 
// Related Topics 数组 哈希表 
// 👍 119 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
class Solution {
    public int countCharacters(String[] words, String chars) {
        if(words.length == 0)     return 0;
        Map<Character,Integer> charCnt = new HashMap<Character, Integer>();
        int length = chars.length();
        for (int i = 0; i < length; i++) {
            char c = chars.charAt(i);
            charCnt.put(c,charCnt.getOrDefault(c,0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character,Integer> wordCnt = new HashMap<>();
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                char c = word.charAt(i);
                wordCnt.put(c,wordCnt.getOrDefault(c,0) + 1);
            }
            boolean isAns = true;
            for (int i = 0; i < wordLength; i++) {
                char c = word.charAt(i);
                if (charCnt.getOrDefault(c,0) < wordCnt.getOrDefault(c,0)){
                    isAns = false;
                    break;
                }
            }
            if (isAns){
                ans += word.length();
            }
        }
        return ans;
    }
}

 */
class Solutio_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] c = new int[26];
        for(char cc : chars.toCharArray()) {
            c[(int)(cc - 'a')] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(int)(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }
}



//leetcode submit region end(Prohibit modification and deletion)
