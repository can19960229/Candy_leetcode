package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/22 10:05
 *
 * @Classname 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class 判断一棵二叉树是否为搜索二叉树和完全二叉树 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public boolean[] judgeInt(TreeNode root){
        boolean[] b = new boolean[2];
        b[0] = isVaildBST(root);
        b[1] = isCompleteTree(root);
        return b;
    }
    //二叉搜索树，中序遍历，判断结果是否是升序的
    public boolean isVaildBST(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        for (int i = 1; i <list.size() ; i++) {
            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    //完全二叉树
    //层序遍历，直到遇到第一个空节点，完全二叉树遇到空节点之后剩余的应当全是空节点
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
