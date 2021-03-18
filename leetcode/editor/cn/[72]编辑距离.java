//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1461 👎 0

/**
 * 同类问题
 * 「力扣」第 1143 题：最长公共子串（中等）；
 * 「力扣」第 10 题：正则表达式匹配（困难）；
 * 「力扣」第 44 题：通配符匹配（困难）；
 * 「力扣」第 97 题：交错字符串（困难）；
 * 「力扣」第 115 题： 不同的子序列（困难）；
 * 「力扣」第 583 题：两个字符串的删除操作（中等）；
 * 「力扣」第 718 题：最长重复子数组（中等）；
 * 「力扣」第 1035 题：不相交的线（中等）；
 * 「力扣」第 1092 题： 最短公共超序列（困难）。
 *
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_72 {
    /**
     * 递归方法，但是会产生很多重复子问题 —— 会超时
     * 使用字符串子串进行操作，但是在java中如此做会占用大量的空间，因此我们使用将StringString转换为char[]的方法
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_1(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        return recur(w1,word1.length() - 1,w2,word2.length() - 1);
    }

    private int recur(char[] w1, int x, char[] w2, int y) {
        if (x == -1 || y == -1)
            return Math.max(x,y) + 1;
        if (w1[x] == w2[y])
            return recur(w1, x-1, w2, y-1);
        else return Math.min(Math.min(recur(w1, x - 1, w2, y - 1), //替换
                recur(w1, x - 1, w2, y)), //删除
                recur(w1, x, w2, y - 1)) + 1; //插入
    }

    /**
     * 备忘录记录重复子问题 自顶向下
     */
    int[][] mem;
    public int minDistance_2(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        mem = new int[w1.length][w2.length];
        return recur_2(w1, word1.length() - 1, w2, word2.length() - 1);
    }
    private int recur_2(char[] w1, int x, char[] w2, int y) {
        if (x == -1 || y == -1)
            return Math.max(x,y) + 1;
        if (w1[x] == w2[y])
            return recur_2(w1,x - 1,w2,y - 1);
        else {
            if (mem[x][y] != 0)
                return mem[x][y];
            int res = Math.min(Math.min(recur(w1, x - 1, w2, y - 1), //替换
                    recur(w1, x - 1, w2, y)), //删除
                    recur(w1, x, w2, y - 1)) + 1; //插入
            mem[x][y] = res;
            return res;
        }
    }

    /**
         * DP table记录重复子问题  自底向上
         * @param word1
         * @param word2
         * @return
         */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //第一行
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2 ; j++) {
                if (word1.charAt(i - 1) == word2.charAt( j - 1) )
                    dp[i][j] = dp[i - 1][j- 1];
                else
                    //insert = dp[i][j - 1]  插入  replace = dp[i - 1][j - 1] 替换 delete = dp[i - 1][j] 删除
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i][j - 1]),dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
