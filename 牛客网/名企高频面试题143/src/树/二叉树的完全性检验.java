package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/15 9:39
 *
 * @Classname 二叉树的完全性检验
 * Description: 测试
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class 二叉树的完全性检验 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reachedEnd = false;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (reachedEnd && cur != null){
                return false;
            }
            if (cur == null){
                reachedEnd = true;
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }
}
