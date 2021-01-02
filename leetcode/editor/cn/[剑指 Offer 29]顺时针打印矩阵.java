//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_29_1 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // l 左  r 右  t 上  b 下
        int l = 0,r = matrix[0].length - 1, t = 0, b = matrix.length - 1,x = 0;
        int [] res = new int [(r + 1) * (b + 1)];
        while (true){
            for (int i = 1; i<=r ;i++)
                res[x++] = matrix[t][i];    //左到右
            if ( ++t > b)
                break;
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r];    //从上到下
            if (l > --r)
                break;
            for (int i = r; i >= l;i--)
                res[x++] = matrix[b][i];    //右到左
            if (t > --b)
                break;
            for (int i = b; i>= t;i--)
                res[x++] = matrix[i][l];    //下到上
            if (++l > r)
                break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
