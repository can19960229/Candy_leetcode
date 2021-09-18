package 队列;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/25 10:29
 *
 * @Classname 二叉树的层序遍历
 * Description: 测试
 */

import java.util.*;

/**
 *
 */
public class 二叉树的层序遍历 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return null;
        q.offer(root);
        //保存层序遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        while (q.size() > 0){
            final int size = q.size();
            //当前层的结果存放于tmp链表中
            List<Integer> temp = new LinkedList<>();
            //遍历当前层的每个结点
            for (int i = 1; i <= size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            ans.add(temp);
        }
        return ans;
    }
    public List<List<Integer>> level(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 1;i <= size;++i){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (root.right != null){
                    queue.offer(node.right);
                }
                if (root.left != null)
                    queue.offer(node.left);
            }
            list.add(level);
        }
        return list;
    }


    public static void main(String[] args) {

    }
}
