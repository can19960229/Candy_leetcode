package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/16 10:58
 *
 * @Classname 最长回文串
 * Description: 测试
 */

/**
 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class 最长回文串 {
    public int longestPalindrome(String s){
        if (s == null)
            return 0;
        char[] chars = s.toCharArray();
        boolean[] arr = new boolean[58];  //默认都为false
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'A'] = !arr[chars[i] - 'A'];  //如果出现奇数次，则置为true
        }
        int singleCharsCount = 0;
        for (int i = 0;i < arr.length;i++){
            if (arr[i]){ // 如果出现奇数，则为true，进行加一
                singleCharsCount++;
            }
        }
        return singleCharsCount == 0 ? chars.length : chars.length + 1 - singleCharsCount;
    }
}
