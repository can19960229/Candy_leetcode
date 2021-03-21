//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 655 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray,0,len,stack,res);
        return res;
    }

    /**
     *
     * @param charArray
     * @param index 起始字符的索引
     * @param len 字符串s的长度，可以设置为全局变量
     * @param path 记录从根节点到叶子节点的路径
     * @param res 记录所有的结果
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <len; i++){
            //因为截取字符串是消耗性能的，采用传子串的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray,index,i)){
                continue;
            }
            path.addLast(new String(charArray,index,i+1-index));
            dfs(charArray,i+1,len,path,res);
            path.removeLast();
        }
    }

    /**
     * 采用动态规划，把回文子串的结果记录在一个表格里
     * @param charArray
     * @param left 子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right){
            if (charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
