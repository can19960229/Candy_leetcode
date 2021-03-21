//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 408 👎 0


import org.omg.CORBA.MARSHAL;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = n - 2;i >= 0;i--){
            f[i][i] = 1;
            for (int j = i + 1;j < n;j++){
                if (s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i+ 1][j-1]+ 2;
                }else {
                    f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
                }
            }
        }
        return f[0][n-1];
    }

    /**
     * 以最小插入次数构造回文串
     * @param s
     * @return
     */
    int minInsertions(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        //base case : i==j时，dp[i][j] = 0,单个字符本身就是回文串
        //dp数组已经全部初始化为0，base case已初始化

        //从下向上遍历
        for (int i = n - 2; i >= 0 ; i++) {
            //从左向右遍历
            for (int j = i + 1;j < n;j++){
                //根据s[i]和s[j]进行状态转移
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i + 1][j],dp[i][j - 1]) + 1;
                }
            }
        }
        //根据dp数组的定义，题目要求的答案是dp[0][n - 1]
        return dp[0][n - 1];
    }

    /**
     * 把二维压缩成一维
     */
    int minInsertions_1(String s){
        int n = s.length();
        int[] dp = new int[n];
        int temp = 0;
        for (int i = n - 2;i >= 0;i--){
            //记录dp[i+1][j-1]
            int pre = 0;
            for (int j = i + 1;j < n;j++){
                temp = dp[j];

                if (s.charAt(i) == s.charAt(j)){
                    dp[j] = pre;
                }else {
                    dp[j] = Math.min(dp[j],dp[j - 1]) + 1;
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
