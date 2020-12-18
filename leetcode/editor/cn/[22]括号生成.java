//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1385 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {

    /*
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n,"");
        return result;
    }

    //如果s不合法就退出
    // left 随时加，只要不超标
    // right 左个数>右个数 就添加
    private void _generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n){
            result.add(s);
            return;
        }
        //process current logic :left ,right

        //drill down
        //左括号增加的条件
        if (left < n)
            _generate(left + 1,right,n,s+"(");
        //右括号增加的条件
        if (left > right)
            _generate(left,right + 1 ,n,s+")");

        //reverse status
    }
*/

    /**
     * 先把合法性抛在一边，一共有2n个格子，既可以放左括号也可以放右括号，产生所有可能结果
     *
     *
     * */
    public List<String> generateParenthesis(int n) {
        //0 : 当前的level
        //格子总数：2n
        //当前字符串： ""
        _generate(0,2 * n,"");
        return null;

    }

    private void _generate(int level, int max, String s) {
        //先写出递归模板
        //terminator  终止条件
        if (level >= max){
            System.out.println(s);
            return;
        }
        //process
        //当前逻辑  加左括号，加右括号
        String s1 = s + "(";
        String s2 = s + ")";
        //drill down
        _generate(level + 1,max,s1);
        _generate(level + 1,max,s2);

        //reverse status 都是局部变量，不需要释放内存
    }


}
//leetcode submit region end(Prohibit modification and deletion)
