/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/22 20:42
 * version 1.0
 * Description:
 *
 * 先序：根左右
 * 中序：左根右
 * 后序：左右根
 */

import java.util.ArrayList;
import java.util.List;

/**
 *public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
public class 二叉树的先序_中序_后序遍历 {

    List<Integer> front = new ArrayList<>();
    List<Integer> mid = new ArrayList<>();
    List<Integer> back = new ArrayList<>();

    /**
     * 递归
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        PreOrderTraversal(root);
        InOrderTraversal(root);
        PostOrderTraversal(root);

        return new int[][]{
                front.stream().mapToInt(Integer::valueOf).toArray(),
                mid.stream().mapToInt(Integer::valueOf).toArray(),
                back.stream().mapToInt(Integer::valueOf).toArray()
        };
    }

    //前序遍历
    public void PreOrderTraversal(TreeNode root){
        if(root == null) return;
        front.add(root.val);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }
    //中序遍历
    public void InOrderTraversal(TreeNode root){
        if(root == null) return;
        InOrderTraversal(root.left);
        mid.add(root.val);
        InOrderTraversal(root.right);
    }
    //后序遍历
    public void PostOrderTraversal(TreeNode root){
        if(root == null)
            return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        back.add(root.val);
    }



}
