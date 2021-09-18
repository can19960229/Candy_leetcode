package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/24 22:01
 *
 * @Classname 翻转二叉树
 * Description: 测试
 */

/**
 *
 */
public class 翻转二叉树 {
    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
    }
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
