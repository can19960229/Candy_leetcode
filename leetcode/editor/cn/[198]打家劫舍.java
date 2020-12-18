//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_198 {

    /**
     * 该方法使用了数组存储结果
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[length - 1];
    }

    /**
     * 可以使用滚动数组，在每个时刻只需要存储前两间房屋最高总金额
     */
    public int rob_2(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int first = nums[0],second = Math.max(nums[0],nums[1]);
        for (int i = 2;i < length;i++){
            int temp = second;
            second = Math.max(first + nums[i],second);
            first = temp;
        }
        return second;
    }

    public int rob_3(int[] nums){
        int pre = 0,cur = 0,tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
