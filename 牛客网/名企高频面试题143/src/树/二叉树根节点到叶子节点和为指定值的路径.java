package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/20 13:56
 *
 * @Classname 二叉树根节点到叶子节点和为指定值的路径
 * Description: 测试
 */

import java.util.ArrayList;

/**
 *
 */
public class 二叉树根节点到叶子节点和为指定值的路径 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();//用于存储结果
    ArrayList<Integer> temp = new ArrayList<>();//用于存储路径
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum){
        dfs(root,sum,0);
        return res;
    }

    private void dfs(TreeNode root, int sum, int cnt) {
        if (root == null)
            return;//如果节点为空，介绍当前递归
        temp.add(root.val);
        cnt += root.val;
        if (root.left == null && root.right == null){
            if (cnt == sum)
                res.add(new ArrayList<>(temp));
        }else {
            dfs(root.left,sum,cnt);//递归左子树
            dfs(root.right,sum,cnt);//递归右子树
        }
        temp.remove(temp.size() - 1);
    }
}
