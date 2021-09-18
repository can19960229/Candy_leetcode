package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/22 10:51
 *
 * @Classname 完全二叉树的节点数
 * Description: 测试
 */

/**
 * 
 */
public class 完全二叉树的节点数 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int nodeNum(TreeNode head){
        if (head == null){
            return 0;
        }
        return countNodes(head);
    }

    private int countNodes(TreeNode root) {
        TreeNode l = root,r = root;
        //左子树高度
        int hl = 0,hr = 0;
        while (l != null){
            l = l.left;
            hl++;
        }
        //右子树高度
        while (r != null){
            r = r.right;
            hr++;
        }
        //满二叉树计算
        if (hl == hr){
            return (int)Math.pow(2,hl) - 1;
        }
        //普通二叉树
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
