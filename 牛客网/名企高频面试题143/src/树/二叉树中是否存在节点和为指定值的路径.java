package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/21 10:27
 *
 * @Classname 二叉树中是否存在节点和为指定值的路径
 * Description: 测试
 */

import java.util.Stack;

/**
 *
 */
public class 二叉树中是否存在节点和为指定值的路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


}
