//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_34 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;

    }
    private void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<>(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }


    public List<List<Integer>> pathSum_1(TreeNode root,int sum){
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        //如果为空直接返回
        if (root == null)
            return;
        //创建一个临时储存的路径path
        List<Integer> path = new ArrayList<>(list);
        //把当前节点值介入到path中
        path.add(new Integer(root.val));
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null){
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到一组答案，放入到reslt中
            if(sum == root.val)
                result.add(path);
            //到达叶子节点后还没有等于要找的值，直接返回
            return;
        }
        //如果没有到达叶子节点，就继续从他的左右两个子节点往下找，但是sum要减去当前节点的值
        dfs(root.left,sum - root.val, path,result);
        dfs(root.right,sum - root.val, path,result);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
