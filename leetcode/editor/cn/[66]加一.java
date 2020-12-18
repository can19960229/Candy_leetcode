//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 572 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_66 {
    public int[] plusOne(int[] digits) {


        for (int i = digits.length -1 ; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            //如果最后一位对10求余不等于0，则for循环值进行了一次就返回了，只把最后的数字进行了加一
            //不然的话，对10求余等于0，之后还自增加一表示进位了，再对进位加一的那个书判断是否等于10
            if (digits[i] != 0){
                return digits;
            }

        }
        //如果一直进位到超过一开始的数组长度，则扩大数组
        digits = new int[digits.length + 1 ];
        digits[0] = 1;
        return digits;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
