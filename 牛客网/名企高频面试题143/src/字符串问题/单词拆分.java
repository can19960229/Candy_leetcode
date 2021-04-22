package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 10:12
 *
 * @Classname 单词拆分
 * Description: 测试
 */

import java.util.List;

/**
 *
 */
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        int max_length = 0;
        for (String temp : wordDict) {
            max_length = Math.max(temp.length(), max_length);
        }
        //memo[i]表示s中以i-1结尾的字符串是否可被wordDict拆分
        boolean[] memo = new boolean[n+1];
        memo[0]= true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && max_length >= i - j; j--) {
                if (memo[j] && wordDict.contains(s.substring(j,i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
