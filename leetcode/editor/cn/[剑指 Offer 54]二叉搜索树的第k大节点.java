//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_54_1 {
    private int result;
    private int k;
    public int kthLargest(TreeNode root, int k) {
        //二叉搜索树的中序遍历是升序的
        this.k = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null){
            return;
        }
        //遍历右子节点
        inorder(root.right);
        //计数，如果当前节点是第k个节点，则结果递归，记录当前节点的值
        if (--this.k == 0){
            this.result = root.val;
            return;
        }
        inorder(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
