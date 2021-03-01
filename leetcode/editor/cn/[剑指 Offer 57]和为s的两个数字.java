//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 76 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 暴力 超过时间复杂度 O(n²) 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        int count = 0; //记录下小于target的数组界限
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target){
                count = i;
            }else
                count = nums.length;
        }
        int[] res = new int[2];
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if ((target - nums[i]) == nums[j]){
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
            }
        }
        return res;
    }

    /**
     *  改用哈希表，把寻找target - x 的时间复杂度从 N 降低到 1
     *  对每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，这样保证不会让 x 和自己匹配
     *  时间复杂度 O(n) 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer,Integer> dic = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (dic.containsKey(target-nums[i])){
                res[0] = target- nums[i];
                res[1] = nums[i];
            }
            dic.put(nums[i],i);
        }
        return res;
    }

    /**
     * 双指针法
     *
     * 1、定义两个指针，分别指向 最小数(0下标) 和 最大数(0下标)
     * 2、通过两个指针，来遍历数组：
     *
     *       两数之和 < 目标值，小数指针后移
     *       两数之和 > 目标值，大数指针前移
     *       两数之和 == 目标值，返回这两个数
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || target < 0){
            return new int[0];
        }
        int start = 0, end = nums.length - 1;
        while (start < end){
            int result = nums[start] + nums[end];
            if (result < target)
                start++;
            else if (result > target)
                end--;
            else
                return new int[]{nums[start],nums[end]};
        }
        return new int[0];
    }

    /**
     *
     * 总结：
     *
     * 方法二：哈希表
     * 运行成功:
     * 		测试用例:[16,16,18,24,30,32]
     * 		48
     * 		测试结果:[18,30]
     * 		期望结果:[16,32]
     * 	该结果和期望结果不一致，但结果是对的
     *
     * 	而方法三：双指针法的测试结果和期望结果是一致的
     * 	说明方法二虽然得出来了结果，但是不是最后期望的结果
     *
     * 	方法三：双指针法
     * 		运行成功:
     * 			测试用例:[16,16,18,24,30,32]
     * 			48
     * 			测试结果:[16,32]
     * 			期望结果:[16,32]
     *
     * 	由此可见：	从期望结果可以侧面反映出需要用哪种方法来解答，并且自己的答案是否是期望答案
     */
}
//leetcode submit region end(Prohibit modification and deletion)
