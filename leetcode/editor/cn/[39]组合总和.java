//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1216 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_39 {
    /**
     * 我们定义递归函数 dfs(target, combine, idx) 表示当前在 candidates 数组的第 idx 位，还剩 target 要组合，已经组合的列表为 combine。
     * 递归的终止条件为 target <= 0 或者 candidates 数组被全部用完。
     * 那么在当前的函数中，每次我们可以选择跳过不用第 idx 个数，即执行 dfs(target, combine, idx + 1)。
     * 也可以选择使用第 idx 个数，即执行 dfs(target - candidates[idx], combine, idx)，注意到每个数字可以被无限制重复选取，因此搜索的下标仍为 idx。
     *
     * @param candidates
     * @param target
     * @return
     */
    /*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length)
            return;
        if (target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        //直接跳过
        dfs(candidates,target,ans,combine,idx+1);
        //选择当前数
        if (target-candidates[idx] >= 0){
            combine.add(candidates[idx]);
            //由于可以重复利用，则下一轮搜索的结果依然是i
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    */

/*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0)
            return ans;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,ans);
        return ans;
    }
*/
    /**
     *
     * @param candidates 候选数组
     * @param begin 搜索起点
     * @param len 冗余变量，是candidates里的属性，可以不传
     * @param target 每减去一个元素，目标值变小
     * @param path 从根节点到叶子节点的路径，是一个栈
     * @param ans 结果集列表
     */
    /*
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        //target 为负数和0的时候不再产生新的孩子节点
        if (target < 0)
            return;
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        //从begin开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            //由于每一个元素可以重复利用，下一轮搜索的起点依然是i
            dfs(candidates, i, len, target - candidates[i], path, ans);
            //状态重置
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    */

    //剪枝提速

    /**
     * 如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。
     * 基于这个想法，我们可以对输入数组进行排序，添加相关逻辑达到进一步剪枝的目的；
     *
     * 排序是为了提高搜索速度，能剪枝就尽量剪枝。
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0)
            return ans;
        //排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,ans);
        return ans;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        //由于进入更深层的时候，小于0的部分被剪枝，因此递归终止条件值只判断等于0的情况
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //重点理解这里的剪枝，前提是候选数组已经有序
            if (target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, i, len, target - candidates[i], path, ans);
            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
