package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/2 21:30
 *
 * @Classname 两颗二叉搜索树中的所有元素
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class 两颗二叉搜索树中的所有元素 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1,TreeNode root2){
        dfs(root1);
        dfs(root2);
        Collections.sort(list);
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left != null){
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null){
            dfs(root.right);
        }
    }

}
