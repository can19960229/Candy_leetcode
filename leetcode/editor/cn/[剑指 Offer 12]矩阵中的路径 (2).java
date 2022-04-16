//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 233 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();//将要查找的字符串转换为字符数组
        //遍历给出的二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,i,j,0))//进行递推剪枝工作
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //终止条件判定， (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        //终止条件判定，字符串 word 已全部匹配
        if (k == word.length - 1) return true;
        board[i][j] ='\0'; //标记当前矩阵元素： 代表此元素已访问过，防止之后搜索时重复访问。
        boolean res = dfs(board,word,i + 1,j,k+1) || dfs(board,word,i - 1,j,k+ 1)||
                dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = word[k];//还原当前矩阵元素
        return res; //代表是否搜索到目标字符串
    }
}
//leetcode submit region end(Prohibit modification and deletion)
