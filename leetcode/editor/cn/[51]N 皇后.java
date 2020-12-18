//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 676 👎 0


import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_51 {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        List<char[]> board = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            char[] chars = new char[n];
//            Arrays.fill(chars,'.');
//            board.add(chars);
//        }
//        backtracking(n,0,board,result);
//        return result;
//    }
//
//    private void backtracking(int n, int row, List<char[]> board, List<List<String>> result) {
//        if (n == row){
//            List<String> path = new ArrayList<>();
//            for (char[] chars : board) {
//                path.add(new String(chars));
//            }
//            result.add(path);
//            return;
//        }
//        for (int col = 0; col < n; col++) {
//            if (isValid(row,col,n,board)){
//                board.get(row)[col] = 'Q';
//                backtracking(n,row+1,board,result);
//                board.get(row)[col]='.';
//            }
//        }
//    }
//
//    private boolean isValid(int row, int col, int n, List<char[]> board) {
//
//        for (int i = 0; i < row; i++) {
//            if (board.get(i)[col] == 'Q'){
//                return false;
//            }
//        }
//        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0 ; i--,j--) {
//            if (board.get(i)[j] == 'Q'){
//                return false;
//            }
//        }
//        for (int i = row - 1,j = col + 1;i >= 0 && j < n;i--,j++){
//            if (board.get(i)[j] == 'Q'){
//                return false;
//            }
//        }
//        return true;
//    }


    /**
     * 方法二：位运算
     */

    private int size;
    private int count;

    private void solve(int row,int ld, int rd){
        if (row == size){
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
            while (pos != 0){
                int p = pos &(~pos);
                pos &= pos - 1;
                solve(row | p,(ld | p) << 1,(rd | p) >> 1);
            }
        }
        public int totalNQueens(int n){
            count = 0;
            size = (1 << n) - 1;
            solve(0,0,0);
            return count;
        }




}
//leetcode submit region end(Prohibit modification and deletion)
