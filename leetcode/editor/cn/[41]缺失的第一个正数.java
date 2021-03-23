//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1014 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;  //将负数变为n + 1
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]); //将 ≤ n的元素对应位置变为负数
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i + 1; //返回第一个大于0的元素下标 + 1
            }
        }
        return n + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
