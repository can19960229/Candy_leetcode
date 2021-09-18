package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/1 20:33
 *
 * @Classname 把二叉搜索树转换为累加树
 * Description: 测试
 */

/**
 *
 */
public class 把二叉搜索树转换为累加树 {

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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
