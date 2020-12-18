//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2620 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];//初始值设为列表的第一个元素
        int sum = 0;
        for (int num : nums) {
            //如果当前指针所指元素之前的和小于0，则丢弃当前元素之前的序列
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            //计算当前和，最大和，取两者的最大
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public int maxSubArray_2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
