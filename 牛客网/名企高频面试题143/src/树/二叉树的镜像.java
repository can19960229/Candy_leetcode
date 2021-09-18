package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/6 9:20
 *
 * @Classname 二叉树的镜像
 * Description: 测试
 */

/**
 *
 */
public class 二叉树的镜像 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode Mirror(TreeNode pRoot){
        if (pRoot == null)
            return pRoot;
        TreeNode temp = pRoot.right;
        pRoot.right = pRoot.left;
        pRoot.left = temp;
        if (pRoot.left != null)
            Mirror(pRoot.left);
        if (pRoot.right != null)
            Mirror(pRoot.right);

        return pRoot;
    }


}
