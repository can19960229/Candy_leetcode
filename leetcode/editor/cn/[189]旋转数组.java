//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 921 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_189 {

    public void rotate(int nums[], int k) {
        int n = nums.length;
        int temp[] = new int[n]; //临时数组
        //把原数组值放到一个临时数组中
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        //然后把临时数组的值重新放到原数组，并且往后移动k位
        for (int i = 0; i < n; i++) {
            nums[(i+k) % n ]= temp[i];
        }
    }

    /**
     * 先反转全部数组，在反转前k个，最后在反转剩余的
     * @param nums
     * @param k
     */
    public void rotate_2(int[] nums, int k) {
        int n = nums.length ;

        k %= n;
        reverse(nums,0,n - 1); //先翻转全部的元素
        reverse(nums,0,k- 1); //反转前k个元素
        reverse(nums,k,n - 1);  //反转剩余的

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
