//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 排序 数组 
// 👍 415 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length][2];
        int idx = 0;
        //遍历区间列表
        //首先将新区间左边且相离区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            res[idx ++] = intervals[i++];
        }
        //接着判断当前区间是否与新区间重叠，重叠的话就进行合并，知道遍历到当前区间在新区间的右边且相离
        //将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.min(intervals[i][1],newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        //最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length){
            res[idx++] = intervals[i++];
        }
        return Arrays.copyOf(res,idx);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
