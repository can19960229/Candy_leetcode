//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 76 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_17_10 {
    public int majorityElement_1(int[] nums) {
        /**
         * 哈希表 ，时间复杂度 O（N2），空间复杂度O（N）
         */
        HashMap<Integer,Integer> map = new HashMap<>();
        int p = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > p){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 排序后，使用双指针，统计大于超过一半长度的元素
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]){
                end++;
            }else {
                start = end + 1;
                end++;
            }
            if (end - start + 1 > nums.length / 2){
                return nums[start];
            }
        }
        return -1;
    }

    /**
     * 排序后验证中间元素
     * @param nums
     * @return
     */
    public int majorityElement_3(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[nums.length / 2];
        int number = 0;
        for (int num : nums) {
            if (num == ans){
                number++;
            }
        }
        if (number > nums.length / 2){
            return ans;
        }
        return -1;
    }

    /**
     * 首先给这个数组排序，然后如果有主要元素，那么这个元素一定在中间，
     * 可以定义两个指针，从这个数的左右开始扫描，扫描到一个相同的数。
     * 令左指针减一或右指针加一，当扫描完成后，令右指针-左指针-2+1，
     * 由于一开始两个指针相差2，所以要减去2，这样的话就算得了扫描的个数，
     * 但是还有中间的那个数没有算，所以需要加一，最后判断这个算得的数是否大于数组的一半即可
     * 时间复杂度：排序的时候是快排O(n*logn)+O(n)+O(n)，空间为O(1)
     *
     */

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int left = nums.length/2-1, right = nums.length/2+1, num = nums[nums.length/2];

        while (left >= 0 && nums[left] == num) {
            left --;
        }

        while (right < nums.length && nums[right] == num) {
            right ++;
        }
        if (right - left - 1> nums.length/2) {
            return num;
        }
        return -1;
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement_4(int[] nums) {
        int temp = 0,count = 0;
        for (int num : nums) {
            if (count == 0){
                temp = num;
                count = 1;
            }
            else {
                if (temp == num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        if (count > 0){
            int n = 0;
            for (int i : nums) {
                if (i == temp)
                    n++;
            }
            if (n > nums.length / 2){
                return temp;
            }

        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
