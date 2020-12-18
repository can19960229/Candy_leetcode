//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 740 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_62 {
    //有冗余，不需要传整个数组

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];

        //把最下面一行和最右边一侧的值赋为1，类似斐波那契数列的a[0]=0,a[1]=1
        for (int i = 0; i < n; i++) {
            nums[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }



    /**
     * 动态规划优化
     * 自底向上
     */
    public int uniquePaths_3(int m, int n) {

        int[] cur = new int[n];
        //一开始把最下面的一行都赋值为1
        Arrays.fill(cur,1);
        //往上一行进行填充数据
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }



}
//leetcode submit region end(Prohibit modification and deletion)
