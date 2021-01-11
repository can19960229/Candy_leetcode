/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/11 21:38
 * version 1.0
 * Description: 最近公共祖先问题
 */

/**
 *
 */
public class 最近公共祖先 {
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return CommonAncestor(root,o1,o2).val;
    }
    public TreeNode CommonAncestor(TreeNode root,int o1,int o2){
        if(root == null || root.val == o1 || root.val == o2){
            return root;
        }
        TreeNode left = CommonAncestor(root.left,o1,o2);
        TreeNode right = CommonAncestor(root.right,o1,o2);
        if(left == null){//都在右侧
            return right;
        }
        if(right == null){//都在左边
            return left;
        }
        return root;//在左右两侧
    }
}
