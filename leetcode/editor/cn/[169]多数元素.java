//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 782 👎 0


import javafx.scene.input.InputMethodTextRun;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> counts = count(nums);
        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (max == null || entry.getValue() > max.getValue()){
                max = entry;
            }
        }
        return max.getKey();
    }
    private Map<Integer,Integer> count(int[] nums){
        Map<Integer,Integer> res = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length - 1 ; i++){
            if(!res.containsKey(nums[i])){
                res.put(nums[i],1);
            }else {
                res.put(nums[i],res.get(nums) +1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
