//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_53_1 {
    /**
     * 代码冗余，并且测试用例
     * 解答失败:
     * 		测试用例:[5,7,7,8,8,10]
     * 		6
     * 		测试结果:1
     * 		期望结果:0
     * @param nums
     * @param target
     * @return
     */
    public int search_1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int count_start = 0,count_end = 0;
        int res;
        for (int i = 0; i < nums.length - 1; i++) {
            int mid = (end - start) /2 + start;
            if (nums[mid] == target){
                count_start = mid;
                count_end = mid;

                if (nums[count_start] == target){
                    count_start --;
                }else if (nums[count_end] == target){
                    count_end ++;
                }
            }else if (nums[mid] < target){
                start = mid + 1;
            }else if (nums[mid] > target){
                end = mid - 1;
            }
        }
        res = count_end - count_start + 1;
        return res;
    }

    /**
     * 由于数组 nums 中元素都为整数，因此可以分别二分查找 target 和 target +1 的右边界，将两结果相减并返回即可。
     * 一个数的出现次数 = 这个数的开始下标 -下一个数的开始下标
     * @param nums
     * @param target
     * @return
     */

    public int search_2(int[] nums,int target){
        if (nums == null){
            return 0;
        }
        return binarySearch(nums,target + 1) - binarySearch(nums,target);
    }

    private int binarySearch(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex){
            int midIndex = leftIndex + (rightIndex - leftIndex) /2;
            if (nums[midIndex] < target){
                leftIndex = midIndex + 1;
            }else {
                rightIndex = midIndex - 1;
            }
        }
        return leftIndex;
    }


    /**
     * 初始化：low = 0, high = nums.length - 1.
     * 当low≤high时递归二分查找：
     * mid = (low + high) / 2
     * 若nums[mid] == target，[low, mid - 1]和[mid + 1, high]都有可能还有target，因为存在重复元素，继续递归查找。
     * 若nums[mid] < target，说明target只可能出现在区间[mid + 1, high]，继续递归查找。
     * 若nums[mid] > target，说明target只可能出现在区间[low, mid - 1]，继续递归查找。
     * 算法结束，返回计数器的值
     */
    int cnt = 0; //计数器
    public int search(int[] nums,int target){
       helper(nums,target,0,nums.length - 1);
       return cnt;

    }
    private void helper(int[] nums, int target, int low, int high) {
        if (low <= high){
            int mid = low + (high - low) /2;
            if (nums[mid] == target){
                cnt++; //计数一次
                helper(nums,target,low,mid - 1);
                helper(nums,target,mid + 1,high);
            }else if (nums[mid] > target){
                helper(nums,target,low,mid - 1);
            }else{
                helper(nums,target,mid + 1,high);
            }
        }
    }

}


//leetcode submit region end(Prohibit modification and deletion)
