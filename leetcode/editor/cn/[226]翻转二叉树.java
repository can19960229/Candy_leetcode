//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_226 {

    /*
    //递归
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }
//        递归交换当前节点的左子树
        TreeNode left = invertTree(root.left);
//        递归交换当前节点的右子树
        TreeNode right = invertTree(root.right);
//        将当前节点的左右子树交换
        root.right = left;
        root.left = right;
        return root;
    }

*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        //将二叉树的节点逐层加入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tem = queue.poll();
            TreeNode left = tem.left;
            tem.left = tem.right;
            tem.right = left;
            if (tem.left!= null){
                queue.add(tem.left);
            }
            if (tem.right!=null){
                queue.add(tem.right);
            }
        }
        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
