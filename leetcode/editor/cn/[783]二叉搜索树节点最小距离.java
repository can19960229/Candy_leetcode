//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_783 {
    /**
     * 中序遍历，然后把遍历出来的结果放进数组中，查找两个相邻数组的最小差值
     * @param root
     * @return
     */
    public int minDiffInBST_1(TreeNode root) {
        List<Integer> l1 = new ArrayList();
        help(root,l1);
        int[] a = new int[l1.size()];
        for(int i=0; i<a.length; i++) {
            a[i] = l1.get(i);
        }
        for(int i=0; i<a.length-1; i++) {
            a[i] = a[i+1]-a[i];
        }
        for(int i=0; i<a.length; i++) {
            if(a[i]<a[0]) {
                a[0] = a[i];
            }
        }
        return a[0];
    }
    public void help(TreeNode root, List<Integer> l1){
        if(root == null)
            return;
        help(root.left,l1);
        l1.add(root.val);
        help(root.right,l1);
    }

    /**
     * DFS
     */
    private int res = Integer.MAX_VALUE;
    private TreeNode pre = null;
    private void DFS(TreeNode node){
        if (node == null)
            return;
        DFS(node.left);
        if (pre != null)
            res = Math.min(node.val - pre.val,res);
        pre = node;
        DFS(node.right);
    }
    public int minDiffInBST_2(TreeNode root){
        DFS(root);
        return res;
    }
    /**
     * BFS
     */
    public int minDiffInBST(TreeNode root){
        int Min = Integer.MAX_VALUE;
        TreeNode preNode = null,curNode = root;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || curNode!= null){
            while (curNode!= null){
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.pop();
            if (preNode != null)
                Min = Math.min(Min,curNode.val - preNode.val);
            preNode = curNode;
            curNode = curNode.right;
        }
        return Min;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
