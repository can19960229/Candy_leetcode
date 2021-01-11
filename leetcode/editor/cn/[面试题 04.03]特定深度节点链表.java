//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 30 👎 0


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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (null != tree){
            int deep = getDeep(tree);
            ListNode[] res = new ListNode[deep];    //用来存储输出结果的数组
            dfs(tree,0,res);
            return res;
        }
        return new ListNode[0];
    }

    private void dfs(TreeNode tree, int deep, ListNode[] res) {
        if (tree != null){
            ListNode node = new ListNode(tree.val);
            //如果res中没有数据，表示当前深度的节点还没添加到res中
            if (res[deep] == null){
                res[deep] = node;
            }else {
                node.next = res[deep];
                res[deep] = node;
            }
            // 先递归遍历右子树是因为，如果先遍历左子树的话，无法获取每个层级链表的最后一个节点
            // 先遍历右子树的话，就相当于先获取到每个层级的后面的节点，然后让当前节点的next指向它
            dfs(tree.right,deep+1,res);
            dfs(tree.left,deep+1,res);
        }

    }

    /**
     * 求当前数的深度
     * @param tree
     * @return
     */
    private int getDeep(TreeNode tree) {

        if (tree == null) return 0;
        return Math.max(getDeep(tree.left),getDeep(tree.right)) + 1;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
