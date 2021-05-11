//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 719 👎 0


import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_56 {
    /**
     * 首先对区间按照起始端点进行升序排序，然后逐个判断当前区间是否与前一个区间重叠，
     * 如果不重叠的话将当前区间直接加入结果集，反之如果重叠的话，就将当前区间与前一个区间进行合并。
     */
    public int[][] merge(int[][] intervals) {
        //先按照区间起始位置排序
        Arrays.sort(intervals,(v1,v2) -> v1[0] - v2[0]);
        //遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for(int[] interval : intervals){
            //如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置
            //则不合并，直接将当前区间加入结果数组
            if (idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else {
                //反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
