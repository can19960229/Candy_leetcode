//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 98 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_61_1 {
    /**
     * set集合
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0,min = 14;
        for (int num : nums) {
            if (num == 0){
                continue; //跳过小王大王
            }
            max = Math.max(max,num); //最大牌
            min = Math.min(min,num); //最小牌
            if (repeat.contains(num)) return false;  //如果有重复，提前返回false
            repeat.add(num);  //添加此牌到set中
        }
        return max - min < 5;
    }

    /**
     * 排序 + 遍历数组
     * @param nums
     * @return
     */
    public boolean isStraight_2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);  //数组排序
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++; //统计大小王的数量
            else if (nums[i] == nums[i + 1]) return false; //若有重复，提前返回false
        }
        return nums[4] - nums[joker] < 5; //最大牌 - 最小牌 < 5 则可构成顺子

    }
}
//leetcode submit region end(Prohibit modification and deletion)
