/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/23 9:37
 * version 1.0
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 二叉树的先序_中序_后序遍历_ {

    List<Integer> front = new ArrayList<>();
    List<Integer> mid = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        PreOrderTraversal(root);
        InOrderTraversal(root);
        PostOrderTraversal(root);
        int[][] res = {


                front.stream().mapToInt(Integer::valueOf).toArray(),
                mid.stream().mapToInt(Integer::valueOf).toArray(),
                post.stream().mapToInt(Integer::valueOf).toArray()
        };
        return res;
    }

    //后序遍历
    private void PostOrderTraversal(TreeNode root) {
        if (root == null)return;
        front.add(root.val);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }
    private void InOrderTraversal(TreeNode root) {
        if (root == null)return;
        InOrderTraversal(root.left);
        mid.add(root.val);
        InOrderTraversal(root.right);
    }
    private void PreOrderTraversal(TreeNode root) {
        if (root == null)return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        post.add(root.val);
    }

}
