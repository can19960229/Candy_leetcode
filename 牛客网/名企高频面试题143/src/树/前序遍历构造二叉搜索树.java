package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/2 21:54
 *
 * @Classname 前序遍历构造二叉搜索树
 * Description: 测试
 */

/**
 *
 */
public class 前序遍历构造二叉搜索树 {
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
    public TreeNode bstFromPreorder(int[] preorder){
        return build(preorder,0,preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode curRoot = new TreeNode(preorder[start]);

        int k = start;
        while (k < end){
            if (preorder[k+1] > curRoot.val)
                break;
            k++;
        }
        curRoot.left = build(preorder,start+1,k);
        curRoot.right = build(preorder,k+1,end);
        return curRoot;

    }


}
