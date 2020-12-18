//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 44 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_01_05 {
    public boolean oneEditAway_01(String first, String second) {
        if (first == null || second == null){
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();

        if (Math.abs(len1 - len2) > 1) return false;
        //保证第一个字符串的长度比第二个字符串长
        if (len2 > len1) return oneEditAway_01(second,first);

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)){
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1: i));
            }
        }
        return true;
    }

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(),len2 = second.length();
        if(Math.abs(len1-len2)>1)  return false;
        int [][]dp = new int [len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=len2;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    //考虑增删改
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i-1][j-1]+1),dp[i][j-1]+1);
                }
            }
        }
        return dp[len1][len2]<=1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
