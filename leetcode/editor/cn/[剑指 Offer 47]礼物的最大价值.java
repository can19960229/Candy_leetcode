//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 108 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 &&i == 0) continue; //起始元素
                if (i == 0) grid[i][j] += grid[i][j-1]; //矩阵第一行元素，只可以从左边到达
                else if (j == 0) grid[i][j] += grid[i - 1][j]; //矩阵第一列元素，只可以从上边到达
                else grid[i][j] += Math.max(grid[i][j - 1],grid[i - 1][j]); //可以从左边或者上边到达
            }
        }
        return grid[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
