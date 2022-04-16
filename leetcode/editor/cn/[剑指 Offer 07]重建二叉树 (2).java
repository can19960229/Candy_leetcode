//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_07 {
    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        //当二叉树没有节点时
        if (preorder == null || preorder.length == 0){
            return null;
        }
        //使用一个Map存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素中序遍历的位置
        Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i],i);
        }
        //递归调用方法，对于前序和中序遍历，下标范围都是从0到n-1，其中n是二叉树节点个数
        TreeNode root = buildTree(preorder,0,length-1,inorder,0,length-1,indexMap);
        return root;
    }

    //前序遍历的第一个节点是根节点
    //找到前序遍历的第一个节点为根节点，找到根节点在中序遍历中的位置，根节点之前的节点都位于左子树，根节点之后的节点都是右子树
    private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                               int[] inorder, int inorderStart, int inorderEnd,
                               Map<Integer, Integer> indexMap) {
        //当开始大于借宿，则当前的二叉树中没有节点，返回空值null
        if (preorderStart > preorderEnd){
            return null;
        }
        int rootVal = preorder[preorderStart];//从前序遍历中找出根节点
        TreeNode root = new TreeNode(rootVal);//重新建立二叉树
        //开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回
        if (preorderStart == preorderEnd){
            return root;
        }else {
            //若开始小于结束，则当前的二叉树中有多个节点
            int rootIndex = indexMap.get(rootVal);//中序遍历中得到根节点的位置
            int leftNodes = rootIndex - inorderStart;//找到左子树的下标范围
            int rightNodes = inorderEnd - rootIndex;//找到右子树的下标范围
            //递归重建左子树和右子树
            TreeNode leftSubtree = buildTree(preorder,preorderStart+1,preorderStart + leftNodes,inorder,inorderStart,rootIndex - 1,indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;

        }
    }

    int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                      //递归终止
        TreeNode node = new TreeNode(preorder[root]);       //建立根节点
        int i = dic.get(preorder[root]);                    //划分根节点、左子树、右子树
        node.left = recur(root + 1,left, i - 1); //开启左子树递归
        node.right = recur(root + i - left + 1,i + 1,right);//开启右子树递归
        return node;                                                  //回溯返回根节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)
