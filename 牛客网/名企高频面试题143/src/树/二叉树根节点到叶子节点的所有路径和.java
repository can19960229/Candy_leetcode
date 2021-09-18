package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/20 13:40
 *
 * @Classname 二叉树根节点到叶子节点的所有路径和
 * Description: 测试
 */

/**
 *
 */
public class 二叉树根节点到叶子节点的所有路径和 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public int sumNumbers(TreeNode root){
        if (root == null){
            return 0;
        }
        return sumNumbers(root,root.val);
    }

    private int sumNumbers(TreeNode root, int sum) {
        if (root.left == null && root.right == null){
            return sum;
        }
        else {
            int res = 0;
            if (root.left != null){
                res += sumNumbers(root.left,sum * 10 + root.left.val);
            }
            if (root.right != null){
                res += sumNumbers(root.right,sum * 10 + root.right.val);
            }
            return res;
        }
    }
}
