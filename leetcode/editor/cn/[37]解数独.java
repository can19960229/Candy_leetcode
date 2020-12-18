//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.'){
                    //棋盘有空位的地方去填1-9
                    for (char c = '1'; c <= '9'; c++) {
                        //判断填进去的数字是否合法
                        if (isVaild(board,i,j,c)){
                            board[i][j] = c;    //填入这个数

                            if (solve(board))
                                return true;    //如果棋盘能解决的话，就说明问题解决了，return true
                            else
                                board[i][j] = '.';  //恢复上一个状态，回溯
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断棋盘的合法性
     * @param board
     * @param row
     * @param col
     * @param c
     * @return
     */
    private boolean isVaild(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;//检查行是否合法
            if (board[row][i] != '.' && board[row][i] == c) return false;//检查列是否合法
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;//检查3*3的格子是否合法
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
