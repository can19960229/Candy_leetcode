package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/16 10:01
 *
 * @Classname 最长回文子串
 * Description: 测试
 */

/**
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class 最长回文子串 {
    //动态规划
    public static int getLongestPalindrome(String A,int n){
        char[] aa = A.toCharArray();
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i <n;i++){
            dp[i][i] = true;
        }
        for (int i= 1;i < n;i++){ //i指向的是字符的最后一位
            for (int j = i - 1;j >= 0;j--){  //j指向的是字符的前部
                if (i - j == 1){ //当两个指针靠近时，直接判断
                    dp[j][i] = (aa[i] == aa[j]);
                    if (max < i - j + 1)
                        max = i - j + 1;
                }
                else{
                    if (dp[j+ 1][i-1] && aa[i] == aa[j]){
                        dp[j][i] = true;
                        if (max < i - j + 1)
                            max = i - j + 1;
                    }else {
                        dp[j][i] = false;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 暴力解法
     * 直接判断每一个子串是否是回文子串，然后取其中最长的值返回
     * @param A
     * @param n
     * @return
     */
    public static int getLongestPalindrome_1(String A,int n) {
        int maxLen = 0;
        //暴力解法
        for(int i = 0; i < n;i++){
            for (int j = i+ 1;j <= n;j++){
                String now = A.substring(i,j);
                if (isPalindrome(now) && now.length() > maxLen){  //判断子串是否是回文串，并且新的子串要大于最大的回文子串值时才更新最大回文子串的值
                    maxLen = now.length();
                }
            }
        }
        return maxLen;
    }
    //判断子串是不是回文子串
    private static boolean isPalindrome(String s) {
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
     * @param A  输入的字符串
     * @param n  字符串的长度
     * @return
     */
    public static int getLongestPalindrome_2(String A,int n) {
        if (n == 0)
            return 0;
        int maxLen = 1;
        //中心枚举到n - 2位置
        for (int i = 0;i < n - 1; i++){
            //比较以i为中心扩散的回文子串 && 以i和i+1为中心扩散的回文子串  哪个大取哪个
            int len = Math.max(centerSpread(A, i, i), centerSpread(A, i, i + 1));
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }

    private static int centerSpread(String s, int left, int right) {
        int len = s.length();
        int l = left;
        int r = right;
        while (l >= 0 &&r <= len - 1){
            //若相等则继续扩散
            if (s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            else {
                break;
            }
        }
        //为什么还要减2，因为上面while循环终止了，此时s.charAt(l) != s.charAt(r)
        //所以次数的回文子串的左右边界确实是l- 1，r - 1
        return r - l + 1 - 2;
    }

}
