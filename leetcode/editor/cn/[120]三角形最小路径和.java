//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 640 👎 0


import java.io.InputStream;
import java.util.List;

/*
* 1. 暴力法，递归，n层，left or right：2^n
* 2. DP
*   a.重复性（分治） problem(i,j) = min(sub(i+1,j),sub(i+1,j+1)) + a[i,j]
*   b.定义状态数组  f[i,j]
*   c.DP方程：f[i,j] = min(f[i+1,j],f[i+1,j+1]) + a[i,j]
*
* */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1;i >= 0; i++) {
            for(int j= 0;j<triangle.get(i).size();j++){
                //左右的最小者，加上自身
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    /**
     * 递归 自顶向下
     * @param triangle
     * @return
     */
    /*
    int row;
    public int minimumTotal_1(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0,0,triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {
        System.out.println("helper : level=" + level + "c = " + c);
        //递归终止条件
        if (level == row - 1){
            return triangle.get(level).get(c);
        }
        int left = helper(level + 1, c, triangle);
        int right = helper(level + 1, c + 1 , triangle);
        return Math.min(left,right) + triangle.get(level).get(c);
    }
    */

    /**
     * 自顶向下，记忆化搜索
     * @param triangle
     * @return
     */
    int row;
    Integer[][] memo;
    public int minimumTotal_2(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0,0,triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {

        if (memo[level][c] != null){
            return memo[level][c];
        }
        if (level == row - 1){
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level+1,c,triangle);
        int right = helper(level+1,c+1,triangle);
        return memo[level][c] = Math.min(left,right) + triangle.get(level).get(c);
    }

    /**
     * 自底向上 DP
     * @param triangle
     * @return
     */
    public int minimumTotal_3(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level>= 0; level++) {
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i],minlen[i+1]) + triangle.get(level).get(i);
            }

        }
        return minlen[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
