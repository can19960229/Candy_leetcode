//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 587 👎 0


import com.sun.crypto.provider.BlowfishKeyGenerator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_209{
    /**
     * 滑动窗口法
     *
     * 滑动窗口法的大致逻辑
     *          int left = 0,right = 0;
     *          while(right < s.length()){
     *              //增大窗口
     *              window.add(s[right]);
     *              right++;
     *
     *              //debug
     *              System.out.println("left:" + left +",right:" + right);
     *              while(window needs shrink){
     *                  //缩小窗口
     *                  window.remove(s[left]);
     *                  left++;
     *                  //进行窗口内数据的一系列更新
     *              }
     *          }
     *现 在开始套模板， 只需要思考以下四个问题：
     * 1、 当移动 right 扩⼤窗⼝， 即加⼊字符时， 应该更新哪些数据？
     * 2、 什么条件下， 窗⼝应该暂停扩⼤， 开始移动 left 缩⼩窗⼝？
     * 3、 当移动 left 缩⼩窗⼝， 即移出字符时， 应该更新哪些数据？
     * 4、 我们要的结果应该在扩⼤窗⼝时还是缩⼩窗⼝时进⾏更新？
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen_1(int target, int[] nums) {
        if (nums.length == 0 || target == 0)
            return 0;

        if (nums.length == 1 && target == nums[0]){
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length){
            sum = sum + nums[right];
            while (sum >= target){
                ans = Math.min(right - left + 1,ans);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 暴力法
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target){
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    min = Math.min(min,j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
