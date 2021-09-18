package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/20 15:12
 *
 * @Classname 最大路径和
 * Description: 测试
 */

/**
 *
 */
public class 二叉树的最大路径和 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = Math.max(0,getMax(root.left));
        int rightMax = Math.max(0,getMax(root.right));
        res = Math.max(res,Math.max(root.val + Math.max(leftMax,rightMax),root.val + leftMax + rightMax));
        return Math.max(leftMax,rightMax) + root.val;
    }

}
