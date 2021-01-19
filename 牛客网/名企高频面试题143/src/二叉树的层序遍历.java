/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/13 15:51
 * version 1.0
 * Description: 测试
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class 二叉树的层序遍历 {
    public static void levelOrder(TreeNode tree){
        if (tree == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);//把数据加入到队列尾部
        while (!queue.isEmpty()){
            //poll方法相当于移除队列头部元素
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
    }
}
