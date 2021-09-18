package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/22 11:38
 *
 * @Classname 找出搜索二叉树中两个错误的节点
 * Description: 测试
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 找出搜索二叉树中两个错误的节点 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    List<Integer> list = new ArrayList<>();
    public int[] findError(TreeNode root){
        int[] res = new int[2];
        if (root == null){
            return res;
        }
        findErrorHelper(root);
        int i,j;
        for (i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)){
                res[1] = list.get(i);
                break;
            }
        }
        for (j = list.size() - 1; j > i; j--) {
            if (list.get(j) < list.get(j - 1)){
                res[0] = list.get(j);
                break;
            }
        }
        return res;
    }
    //中序遍历，把节点的值加入到list中
    private void findErrorHelper(TreeNode root) {
        if (root != null){
            findErrorHelper(root.left);
            list.add(root.val);
            findErrorHelper(root.right);
        }
    }
}
