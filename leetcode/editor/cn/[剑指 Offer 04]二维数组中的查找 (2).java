//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 210 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_04 {
    /**
     * 双指针
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            if (matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    /**
     * 二分法
     * @param matrix
     * @param target
     * @return
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int col = matrix[0].length;

        while (left <= right){
            int mid = (left + right) / 2;
            int value = matrix[mid / col][mid % col];

            if (value == target){
                return true;
            }else if (value < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
