//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 150 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_59_I {
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int n= nums.length;
        if (n * k == 0) return new int[0];
        int[] output = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max,nums[j]);
            }
            output[i] = max;
        }
        return output;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0,i = 1 - k; j < nums.length;i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();  //删除deque中对应的nums[i-1]
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持deque递减
            deque.addLast(nums[j]);
            if (i >= 0){
                res[i] = deque.peekFirst(); //记录窗口最大值
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
