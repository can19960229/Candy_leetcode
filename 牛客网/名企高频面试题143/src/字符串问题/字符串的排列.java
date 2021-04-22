package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 11:36
 *
 * @Classname 字符串的排列
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a']; //统计s1各个字符的个数
            ++cnt2[s2.charAt(i) - 'a']; //统计s2各个字符的个数
        }
        //两个字符串完全相等
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            //滑动窗口，保持窗口的大小始终是2
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
