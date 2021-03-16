//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1751 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_136 {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int singleNumber_1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1){
               ans =  nums[i];
            }
        }
        return ans;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
