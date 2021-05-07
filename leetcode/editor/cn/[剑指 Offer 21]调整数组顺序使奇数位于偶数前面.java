//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_21_1 {
    public int[] exchange_1(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < j && nums[i] % 2 != 0) i++; //是奇数
            while(i < j && nums[j] % 2 == 0) j--; //是偶数
            //交换两个数
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public int[] exchange(int[] nums){
        int slow = 0,fast = 0;
        while (fast < nums.length){
            if ((nums[fast] & 1) == 1)
                swap(nums,slow++,fast);
            fast++;
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
        return;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
