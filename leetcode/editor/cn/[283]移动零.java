//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 767 👎 0

//一维数组的坐标变换
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                //1.当碰到不是0的时候可以进行交换
                //2.把不是0的元素，就把当前值放到非零的位置
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;//把赋值的原位置赋值为0
                }
                j++;
            }

        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
