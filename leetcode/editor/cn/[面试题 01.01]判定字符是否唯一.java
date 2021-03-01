//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 79 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_01_01 {
    public boolean isUnique_1(String astr) {
        int[] arr = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            if (arr[astr.charAt(i)] != 0){
                return false;
            }
            arr[astr.charAt(i)]++;
        }
        return true;
    }
    public boolean isUnique_2(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0){
                return false;
            }else {
                bits |= (1L << move);
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
