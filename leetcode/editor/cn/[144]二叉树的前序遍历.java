//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 388 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class Solution_144 {
    public List<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stk = new LinkedList<>();
        if (root == null){
            return res;
        }

        //先把根节点加入栈
        stk.add(root);
        while (!stk.isEmpty()){
            //如果栈不为空，则返回栈中最后一个元素到答案的list中
            TreeNode node = stk.pollLast();
            res.add(node.val);
            if (node.right != null){
                stk.add(node.right);
            }
            if (node.left != null){
                stk.add(node.left);
            }

        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
