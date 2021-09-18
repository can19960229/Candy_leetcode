//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 460 👎 0


import java.math.BigInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_172 {
//    public int trailingZeroes1(int n) {
//        //计算n！
//        BigInteger nF = BigInteger.ONE;
//        for (int i = 2; i <= n;i++){
//            nF = nF.multiply(BigInteger.valueOf(i));
//        }
//        //计算末尾有多少个0
//        int zeroCount = 0;
//        while (nF.mod(BigInteger.TEN).equals(BigInteger.ZERO)){//判断对10求余之后是否等于0
//            nF = nF.divide(BigInteger.TEN);
//            zeroCount++;
//        }
//        return zeroCount;
//    }
    public int trailingZeroes(int n) {

        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int powerOf5 = 5;
            while (i % powerOf5 == 0) {
                zeroCount += 1;
                powerOf5 *= 5;
            }
        }
        return zeroCount;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
