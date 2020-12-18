//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 755 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import javax.swing.tree.TreeNode;
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
class Solution_94 {

    /*
    递归
     */

 /*   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if (root == null)
            return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

    }*/

    /*
    栈
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        while(root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            stk.pop();
            res.add(root.val);
            root = root.right;
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
