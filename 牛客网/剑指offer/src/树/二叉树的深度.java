package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/6 10:27
 *
 * @Classname 二叉树的深度
 * Description: 测试
 */

/**
 *
 */
public class 二叉树的深度 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int TreeLength(TreeNode root){
        if (root == null)
            return 0;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        return Math.max(l,r) + 1;
    }
}
