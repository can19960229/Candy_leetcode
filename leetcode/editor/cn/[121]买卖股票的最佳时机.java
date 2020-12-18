//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1276 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int ans = 0;//最高收益
        int min = prices[0];//最低价
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i] < min){
                //设置相对最低价
                min = prices[i];
                //计算出最小的，则用遍历到的值减去最小值则得到当前的最高收益，
                // 如果下一个数减去最小值比当前的最高收益还大，则更新最高收益
            }else if (ans < (prices[i] - min)){
                //设定最高盈利
                ans = prices[i] - min;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
