//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 817 👎 0


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

/*
    终止条件
    当前逻辑
    进入到下一层
 */
class Solution_98 {

/*
    //用一个变量记录前一个节点
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        //访问左子树
        if (!isValidBST(root.left)){
            return false;
        }
        //访问当前节点，如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回false;否则继续遍历
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        //访问右子树
        return isValidBST(root.right);

    }

*/
    public boolean isValidBST(TreeNode root){
        return recurse(root,null,null);
    }
    public boolean recurse(TreeNode node,Integer lower,Integer upper){
        //空节点是合理的二叉搜索树
        if (node == null){
            return true;
        }
        //节点不为空，判断节点上的值是否在上下界内
        int val = node.val;
        if (lower != null && val <= lower)return false;
        if (upper != null && val >= upper)return false;

        //将当前节点的值替换为下届，继续检查右边的子节点
        if (!recurse(node.right,val,upper))return false;
        //将当前节点的值替换为上界，继续检查左边的子节点
        if (!recurse(node.left,lower,val))return false;
        return true;
    }






    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
