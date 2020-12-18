//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 963 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_84 {
    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        Arrays.fill(right,n);
//
//        Stack<Integer> mono_stack = new Stack<Integer>();
//        for (int i = 0; i < n; i++) {
//            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
//                right[mono_stack.peek()] = i;
//                mono_stack.pop();
//            }
//            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
//            mono_stack.push(i);
//
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans = Math.max(ans,(right[i] - left[i] - 1) * heights[i]);
//        }
//        return ans;

        //暴力求解法
        int len = heights.length;
        //特判
        if (len == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            //找左边最后一个大于等于heights[i]的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight){
                left--;
            }
            //找到右边最后一个大于等于heights[i]的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight){
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res,width * curHeight);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
