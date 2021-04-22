package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 10:35
 *
 * @Classname 最长回文子序列
 * Description: 测试
 */

/**
 * z最长回文子序列与最长回文子串的区别：子串是字符串中连续的一个序列，子序列是字符串中保持相对位置的字符序列
 * 如 bbbb是字符串的bbbab的子序列而不是子串
 */
public class 最长回文子序列 {

    public int longestPalindromeSubseq(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1;i >= 0;i--){
            dp[i][i] = 1;
            for (int j = i+1;j<len;j++){
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
