//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_125 {
    /*
    public boolean isPalindrome(String s) {
      //自定向下
        //1.filter out number & char
        //2. reverse and compare
        String filteredS = _filterNonNumberAndChar(s);

        return _reverseString(filteredS).equalsIgnoreCase(filteredS);
    }


    private String _reverseString(String filteredS) {

        return new StringBuilder(filteredS).reverse().toString();

    }

    private String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");

    }

     */

    /**
     * 第一种是使用语言中的字符串翻转 API 得到 sgood 的逆序字符串 sgood_rev，只要这两个字符串相同，那么sgood 就是回文串。
     * @param s
     * @return
     */
    /*
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

     */

    //双指针，初始时，左右指针分别指向sgood 的两侧，随后我们不断地将这两个指针相向移动，每次移动一步，并判断这两个指针指向的字符是否相同。当这两个指针相遇时，就说明sgood 时回文串。
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0,right = n - 1;
        while (left < right){
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
