package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/22 11:21
 *
 * @Classname t1树是否包含t2树
 * Description: 测试
 */

/**
 *
 */
public class t1树是否包含t2树 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public boolean contains(TreeNode root1,TreeNode root2){
        if (root1 == null)
            return false;
        return contains(root1.left,root2) || contains(root1.right,root2) || isSunTree(root1,root2);
    }

    private boolean isSunTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }
        return isSunTree(root1.left,root2.left) && isSunTree(root1.right,root2.right);
    }
}
