//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_680 {

    /*

    //不建议 ，特别冗杂
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left), c2 = s.charAt(right);

            if (c1 == c2){
                left++;
                right--;
            }else {
                boolean flag1 = true,flag2 = true;
                for (int i = left,j = right - 1;i < j;i++ ,j--) {
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                for (int i = left + 1,j = right;i < j;i++, j--) {
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3 != c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
    */

    /*

    public boolean validPalindrome(String s) {
        for (int i = 0,j = s.length() - 1; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二十左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

     */

    public boolean validPalindrome(String s) {
        return validPalindrome(s,0,s.length() - 1, 1);
    }

    /**
     *
     * @param s 输入字符串
     * @param left  左指针
     * @param right 右指针
     * @param chance    删除节点的机会次数
     */

    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right){
            return true;
        }
        if (s.charAt(left) == s.charAt(right)){
            return validPalindrome(s,left + 1,right - 1,chance);
        }else {
            if (chance == 0)
                return false;
            return validPalindrome(s,left,right - 1,chance - 1) || validPalindrome(s,left + 1, right,chance-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
