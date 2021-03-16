//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1292 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

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
class Solution {
    public boolean isSymmetric_1(TreeNode root) {
        if (root == null ||(root.left == null && root.right == null))
            return true;
        //返回递归函数，比较左节点，右节点
        return dfs(root.left,root.right);

    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //递归终止条件是两个节点为空
        //或者两个节点中有一个为空
        //或者两个节点的值都不相等
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val){
            return false;
        }
        //再递归的比较，左节点的左孩子 和 右节点的右孩子
        //以及比较，左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0){
            //从队列中取出两个节点，并比较两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            //左节点的左孩子，右节点的右孩子加进队列
            queue.add(left.left);
            queue.add(right.right);
            //左节点的右孩子，右节点的左孩子加进队列
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
