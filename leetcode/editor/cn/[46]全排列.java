//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1181 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_46 {
    List<List<Integer>> res = new LinkedList<>();
    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    //路径：记录在track中
    //选择列表：nums中不存在于track的那些元素
    //结束条件：nums中的元素全部在track中出现
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //出发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);
            track.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
