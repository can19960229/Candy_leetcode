//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 510 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 排序 双指针
     *
     * 将数组 nums 进行排序，记为 numsSort，然后比较 nums 和 numsSort 的元素来决定最左边和最右边不匹配的元素。它们之间的子数组就是要求的最短无序子数组。
     *
     * 首先，从左向右遍历两个数组，找到第一次两个数组中元素不同的位置，即为最左边的不同的位置也就是最短无序连续子数组的左边界。
     *
     * 然后，从右向左遍历两个数组，找到第一次两个数组中元素不同的位置，即为最右边的不同的位置也就是最短无序连续子数组的右边界。
     * @param nums
     * @return
     */
    public int findUnsortedSubarray_1(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int[] numSort = nums.clone();
        Arrays.sort(numSort);
        int left = Integer.MAX_VALUE,right = 0;
        for (int i = 0; i < n; i++) {
            if (numSort[i] != nums[i]){
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0;i--){
            if (numSort[i] != nums[i]){
                right = i;
                break;
            }
        }
        if (right - left >= 0)
            return right - left + 1;
        else
            return 0;
    }

    /**
     * 暴力
     * @param nums
     * @return
     */
    public int findUnsortedSubarray_2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE,prev = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min,nums[k]);
                    max = Math.max(max,nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                    continue;
                int k = 0;
                while (k < i && prev <= nums[k]){
                    prev = nums[k];
                    k++;
                }
                if (k != i){
                    continue;
                }
                k = j;
                while (k < nums.length && prev <= nums[k]){
                    prev = nums[k];
                    k++;
                }
                if (k == nums.length){
                    res = Math.min(res,j - i);
                }
            }
        }
        return res;
    }


    /**
     * 更好的暴力
     * @param nums
     * @return
     */
    public int findUnsortedSubarray_3(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    /**
     * 单调栈代替排序
     * @param nums
     * @return
     */
    public int findUnsortedSubarray_4(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length,r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                l = Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                r = Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;

    }

    /**
     * 这个算法背后的思想是无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
     */

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
