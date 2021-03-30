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


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_198 {

    /**
     * 该方法使用了数组存储结果
     * @param nums
     * @return
     */
    public int rob_1(int[] nums) {
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

    /**
     * 自顶向下
     */

    private int[] memo;
    // 主函数
    public int rob_4(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房⼦开始抢劫
        return dp(nums, 0);
    }
    // 返回 dp[start..] 能抢到的最⼤值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        } // 避免重复计算
        if (memo[start] != -1) return memo[start];
        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        // 记⼊备忘录
        memo[start] = res;
        return res;
    }

    /**
     * 自底向上
     */
    public int rob_5(int[] nums){
        int n = nums.length;
        //dp[i] = x 表示：
        //从第i间房子开始抢劫，最多能抢到的钱为x
        //base case：dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1;i >= 0;i--){
            dp[i] = Math.max(dp[i + 1],nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    /**
     * dp[i] 只和dp[i] 最近的两个状态dp[i + 1] 和dp[i + 2]有关，
     */
    public int rob(int[] nums){
        int n = nums.length;
        //记录dp[i + 1] 和dp[i+2]
        int dpi1 = 0;
        int dpi2 = 0;
        //记录dp[i]
        int dpi = 0;
        for(int i = n - 1;i >= 0;i--){
            dpi = Math.max(dpi1,nums[i] + dpi2);
            dpi2 = dpi1;
            dpi1 = dpi;
        }
        return dpi;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
