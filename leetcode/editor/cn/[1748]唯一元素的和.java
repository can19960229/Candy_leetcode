//给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。 
//
// 请你返回 nums 中唯一元素的 和 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,2]
//输出：4
//解释：唯一元素为 [1,3] ，和为 4 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1,1]
//输出：0
//解释：没有唯一元素，和为 0 。
// 
//
// 示例 3 ： 
//
// 输入：nums = [1,2,3,4,5]
//输出：15
//解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 5 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1748 {
    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public int sumOfUnique_1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }

    /**
     * 计数法
     * @param nums
     * @return
     */
    public int sumOfUnique_2(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int[] arr = new int[101];
        for (int v : nums) {
            arr[v]++;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                res += i;
        }
        return res;
    }

    //利用HashMap存储标识：首次遇到累加，第二次遇到减掉，第三次往后再遇到不处理。
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Integer v = map.get(nums[i]);
            if (v == null){
                res += nums[i];
                map.put(nums[i],1);
            }else if (v > 0){
                res -= nums[i];
                map.put(nums[i],0);
            }
        }
        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
