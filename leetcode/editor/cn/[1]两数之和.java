//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9346 👎 0


import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1 {

    public int[] twoSum(int[] nums, int target){

        //方法一
        //暴力解法 不推荐
//        int[] a = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j =  i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    a[0] = i;
//                    a[1] = j;
//                }
//            }
//
//        }
//        return a;

        //方法二
        //使用了hashMap,降低了时间复杂度，时间复杂度为O(n)
        HashMap<Integer,Integer> map = new HashMap<>();//用一个hashMap储存值和值的下标，如果map中不包含该数值则把数值压入map中，包含的话直接返回
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;



    }
}
//leetcode submit region end(Prohibit modification and deletion)


