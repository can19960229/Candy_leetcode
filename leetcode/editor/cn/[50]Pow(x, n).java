//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
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
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_50 {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
           x = 1 / x;
           N = -N;
        }

        double res = 1.0;
        //把问题分割成pow(x,n/2)
        for(int i=n;i!= 0;i/=2){
            if(i % 2 != 0){
                res *= x;   //如果为奇数则再乘以自己再乘以一个x
            }
            x *= x;     //乘以自己的结果
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
