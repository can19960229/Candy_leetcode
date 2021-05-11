/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/11 17:11
 *
 * @Classname Solution_252
 * Description: 测试
 */

/**
 * 会议室
 *
 * 给定一个会议时间安排的数组intervals，每个会议时间都会包括开始和结束的时间intervals[i] = [starti,endi]，请你判断一个人是否能够参加这里面的全部会议
 * 示例：
 * intervals = [[0,30].[5,10],[15,20]]
 * false
 * 示例：
 * intervals = [[7,10],[2,4]]
 */

import java.util.Arrays;

/**
 * 思路分析
 * 因为一个人在同一时刻只能参加一个会议，因此题目实质是判断是否存在重叠区间，这个简单，将区间按照会议开始时间进行排序，然后遍历一遍判断即可。
 */
public class Solution_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        //将区间按照会议开始实现升序排序
        Arrays.sort(intervals,(v1,v2) -> v1[0] - v2[0]);
        //遍历会议，如果下一个会议在前一个会议之前就开始了，则返回false
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]){
                return false;
            }
        }
        return true;
    }

}
