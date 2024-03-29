////给定一个二叉树，找出其最小深度。
////
//// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
////
//// 说明：叶子节点是指没有子节点的节点。
////
////
////
//// 示例 1：
////
////
////输入：root = [3,9,20,null,null,15,7]
////输出：2
////
////
//// 示例 2：
////
////
////输入：root = [2,null,3,null,4,null,5,null,6]
////输出：5
////
////
////
////
//// 提示：
////
////
//// 树中节点数的范围在 [0, 105] 内
//// -1000 <= Node.val <= 1000
////
//// Related Topics 树 深度优先搜索 广度优先搜索
//// 👍 390 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution_111{
//    public int minDepth(TreeNode root) {
//
//        /*
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//        if (root.left == null || root.right == null) return left + right + 1;
//        return Math.min(left,right) + 1;
//
//         */
//
//        if (root == null) return 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        int depth = 1;
//        while (!q.isEmpty()){
//            int sz = q.size();
//            for (int i = 0; i < sz; i++) {
//                TreeNode cur = q.poll();
//                if (cur.left == null && cur.right == null)
//                    return depth;
//                if (cur.left != null)
//                    q.offer(cur.left);
//                if (cur.left != null)
//                    q.offer(cur.right);
//            }
//            depth++;
//        }
//        return depth;
//    }
//}
//
//
//
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//
//
//}
////leetcode submit region end(Prohibit modification and deletion)
