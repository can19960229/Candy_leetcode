//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 520 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        //递归终止条件是 path的长度等于k
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历可能的搜索起点
        for (int i = begin;i <= n;i++){
            //向路径变量里添加一个数
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            //下一轮搜索，设置搜索起点要加1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            //重点理解这里：深度优先遍历右回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
