//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 996 👎 0


import com.sun.crypto.provider.BlowfishKeyGenerator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        int size = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if (target < nums[mid]){
                right = mid - 1;
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
            else {
                size++;//找到了，并且不等于0，则退出循环
                break;
            }
        }
        //上面通过二分法找到了需要的target值
        if (size == 0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }else {
            int i = mid,j = mid;
            while (i >= 0){//控制左节点不越界
                if (nums[i] == target){
                    i--;
                }else {
                    break;
                }
            }
            while (j <= nums.length - 1){//控制右节点不越界
                if (nums[j] == target){
                    j++;
                }else {
                    break;
                }
            }
            res[0] = i + 1;
            res[1] = j - 1;
            return res;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
