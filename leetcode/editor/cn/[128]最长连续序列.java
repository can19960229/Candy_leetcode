//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 720 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_128 {
    /**
     * 准备一个HashSet，将所有元素入set，之后遍历数组中的每一个数num
     *  如果num - 1存在于set中，那么num不可能是左边界，直接跳过
     *  如果num - 1 不存在set中，那么num会是一个左边界，我们再不断查找num + 1，num + 2....是否存在于set中，来看以num为左边界的连续序列能有多长
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1))
                continue;
            else {
                //len记录以num为左边界的连续序列的长度
                int len = 0;
                while (set.contains(num++))
                    len++;
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
