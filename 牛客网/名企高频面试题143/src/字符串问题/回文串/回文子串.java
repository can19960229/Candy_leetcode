package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/16 10:58
 *
 * @Classname 回文子串
 * Description: 测试
 */

/**
 输入："aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class 回文子串 {
    /**
     * 暴力法
     * @param s
     * @return
     */
    //打印出所有子串
    //判断子串是否是回文子串
    public int countSubstring_1(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i,j);
                if (isPalin(sub)){
                    count++;
                }
            }
        }
        return count;
    }
    //判断子串是否是回文串
    private boolean isPalin(String s) {
        int l = s.length();
        for (int i = 0;i < l/2;i++){
            if (s.charAt(i) != s.charAt(l - i - 1)){  //把第一个与最后一个比较，如果不等直接返回false，如果相等则比较下一个
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩散法
     */
    public int countSubstring(String s) {
        int ans = 0;
        for (int center = 0;center < 2 * s.length() - 1;center++){
            //left 和 right指针和中心点的关系是什么
            //首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                ans ++;
                left--;
                right++;
            }
        }
        return ans;
    }


}
