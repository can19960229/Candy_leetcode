//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 858 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_78 {

    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        helper(res,nums,new ArrayList<Integer>(),0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {
        //终止条件
        if (index == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
//        下到下一层
        helper(res,nums,list,index+1);      //list存储的是中间结果
        list.add(nums[index]);
        helper(res,nums,list,index+1);
        //释放资源
        list.remove(list.size()-1);
    }
    */

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums){
        int n= nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<n)) != 0){
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
