//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 838 👎 0

//测试失败
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_200 {
    int []dx = {-1,1,0,0};
    int []dy = {0,0,-1,1};
    char[] []g;
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0'){
                    continue;
                }
                //g[i][j] = 1 为陆地
                islands += sink(i,j);

            }
        }
        return islands;
    }

    private int sink(int i, int j) {
        //terminator
        if (g[i][j] == '0') return 0;
        g[i][j] = '0';
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k],y = j + dy[k];
            if (x > 0 && x < g.length && y > 0 && y < g[i].length){
                if (g[x][y] == '0') continue;
                sink(x,y);
            }
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
