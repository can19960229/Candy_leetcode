package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/2 22:25
 *
 * @Classname 不同的二叉搜索树II
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class 不同的二叉搜索树II {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n){
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        return getAns(1,n);

    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        //如果没有数字，就把null加进结果
        if (start > end){
            ans.add(null);
            return ans;
        }
        //如果只有一个数字，当前数字作为一棵树加入结果中
        if (start == end){
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = getAns(start,i-1);
            List<TreeNode> rightTrees = getAns(i+1,end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }


}
