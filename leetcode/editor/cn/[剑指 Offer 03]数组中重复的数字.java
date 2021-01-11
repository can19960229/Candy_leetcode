//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 246 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_03_1 {
    public int findRepeatNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber_2(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
    public int findRepeatNumber_3(int[] nums){
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }
    public int findRepeatNumber(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            //位置正确，先不用管
            if (i == nums[i]){
                continue;
            }
            //出现了重复，直接返回
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            //交换
            int temp = nums[nums[i]];
            nums[nums[i]]= nums[i];
            nums[i] = temp;
            //这里的i--是为了抵消上面的i++；
            //交换之后需要原地比较
            i--;

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
