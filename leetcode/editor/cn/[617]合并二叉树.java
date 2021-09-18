//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 688 👎 0


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
class Solution_617 {
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        return dfs(root1,root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = dfs(root1.left,root2.left);
        root1.right = dfs(root2.right,root2.right);
        return root1;
    }

    //非递归的方式进行遍历，因为广度优先需要额外的数据结构来辅助，则借助栈或者队列来完成
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果root1和root2中，只要有一个是null，函数就直接返回
        if (root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (queue.size() > 0){
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val = r1.val + r2.val;
            if (r1.left != null && r2.left != null){
                queue.add(r1.left);
                queue.add(r2.left);
            }
            else if (r1.left == null){
                r1.left = r2.left;
            }
            if (r1.right != null && r2.right != null){
                queue.add(r1.right);
                queue.add(r2.right);
            }
            else if (r1.right == null){
                r1.right = r2.right;
            }
        }
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
