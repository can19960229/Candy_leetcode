//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2675 👎 0


import java.util.*;

// a + b = -c (target)
//1. 暴力求解  使用Set集合，Set集合不可重复单无序   List 排列有序可重复  ——超出时间限制


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    //超出时间限制
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        ans.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(ans);

    }

     */

    /*
    标签：数组遍历
    首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
    如果 nums[i]大于 00，则三数之和必然无法等于 00，结束循环
    如果 nums[i]= nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当 sum = 0 时，nums[L]= nums[L+1] 则会导致结果重复，应该跳过，L++
    当 sum =0 时，nums[R]= nums[R−1] 则会导致结果重复，应该跳过，R--
    时间复杂度：O(n^2)，n 为数组长度

     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // 跳过相同的结果
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  //  跳过相同的结果
                    while (j < k && nums[k] == nums[k + 1]) k--;  //  跳过相同的结果
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
