package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/28 9:22
 *
 * @Classname 验证二叉搜索树
 * Description: 验证一棵树是否是二叉搜索树
 */

import sun.plugin.dom.core.CoreConstants;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class 验证二叉搜索树 {
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

    //非递归的中序遍历
    public boolean isValidBST(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if(root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root){
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }





}
