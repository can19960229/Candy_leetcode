//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 784 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_337 {
    Map<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        //利用备忘录消除重叠子问题
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        //抢,然后去下下家
        int do_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it,not_do);
        memo.put(root, res);
        return res;
    }

    int rob_1(TreeNode root){
        int[] res = dp(root);
        return Math.max(res[0],res[1]);
    }

    /**
     * 返回一个大小为2的数组arr
     * arr[0] 表示不抢root的话，得到的最大钱数
     * arr[1] 表示强root的话，得到的最大钱数
     * @param root
     * @return
     */
    private int[] dp(TreeNode root) {
        if (root == null){
            return new int[]{0,0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //抢，下家就不能抢了
        int rob = root.val +left[0] + right[0];
        //不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0],left[1] + Math.max(right[0],right[1]));
        return new int[]{not_rob,rob};
    }


}
//leetcode submit region end(Prohibit modification and deletion)
