//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1434 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_300 {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS_1(int[] nums) {
        int[] dp = new int[nums.length];
        //base case ：dp数组全都初始化为1
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j = 0;j <i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        //重新遍历一遍数组，找到最长的递增子序列长度
        for(int i = 0;i < dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        //排堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            //要处理的扑克牌
            int poker = nums[i];

            /**
             * 搜索左侧边界的二分搜索
             */
            int left = 0,right = piles;
            while (left < right){
                int mid = (left + right) /2;
                if (top[mid] > poker){
                    right = mid;
                }else if (top[mid] < poker){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            //没有找到合适的排堆，新建一堆
            if (left == piles) piles++;
            top[left] = poker;
        }
        //排堆数就是LIS长度
        return piles;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
