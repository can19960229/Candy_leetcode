//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 
// 👍 217 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public int[] sortedSquares_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    /**
     * 双指针
     * 如果是正数，则值越大平方越大，如果是负数，则越小值越大，则使用两个指针，分别从数组的两端判断哪个元素的绝对值大，绝对值大的先计算
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        int index = length - 1;
        int[] res = new int[length];
        while (index >= 0){
            //判断哪个元素的绝对值大
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[index--] = nums[left] * nums[left];
                left++;
            }else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    /**
     * 通过相加的方式，如果负数的绝对值大，相加的结果肯定是负数，如果正数的绝对值大，那么相加的结果肯定是正数
     * @param nums
     * @return
     */
    public int[] sortedSquares_2(int[] nums) {
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        int index = length - 1;
        int[] res = new int[length];
        while (index >= 0) {
            //判断哪个元素的绝对值大
            if (nums[left] + nums[right] < 0) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }



        /**
         * 冒泡排序
         */
    public static void bubbleSort(int array[]){
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[i]){
                    swap(array,i,j);
                }
            }
        }
    }

    /**
     * 首先拿第一个元素和后面的所有一个个比较，如果比后面的大就交换，所以始终会保证第一个元素是最小的，然后再从第二个第三个，以此类推，
     */
    public static void bubbleSort_1(int[] array){
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (array[j] > array[j + 1]){
                    swap(array,j,j + 1);
                }
            }
        }
    }
    private static void swap(int[] A, int i, int j) {
        if (i != j){
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
