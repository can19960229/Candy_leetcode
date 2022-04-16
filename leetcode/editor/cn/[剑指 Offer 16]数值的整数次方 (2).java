//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 112 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_16 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1 / x;
            b = -b;
        }
        while (b > 0){
            if((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
