//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 463 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        //结果集
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        Integer dp[][] = new Integer[numRows + 1][numRows + 1];
        dp[0][0] = 1;//初始化
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            dp[i][0] = dp[i][i] = 1;
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i;j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                curr.add(dp[i][j]);
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
