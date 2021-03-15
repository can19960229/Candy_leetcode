//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 524 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_40 {
/*
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]){
                freq.add(new int[]{num,1});
            }else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0,target);
        return ans;
    }

    private void dfs(int pos, int rest) {
        if (rest == 0){
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]){
            return;
        }
        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0] ,freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1,rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }


 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)
            return res;
        //关键步骤
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates,len,0,target,path,res);
        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param len 冗余变量
     * @param begin 从候选数组的begin位置开始搜索
     * @param target 表示剩余，这个值一开始等于target，基于题目中说明的“所有数组字（包括目标数）都是正整数"这个条件
     * @param path 从根节点到叶子节点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //大剪枝：减去candidates[i] 小于0，减去后面的candidates[i+1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0)
                break;
            //小剪枝：同一层相同数值的节点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));

        }
    }




}
//leetcode submit region end(Prohibit modification and deletion)
