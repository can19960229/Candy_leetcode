package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/2 21:17
 *
 * @Classname 递增顺序搜索树
 * Description: 测试
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 递增顺序搜索树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (){
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
    List<Integer> temp = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root){
        dfs(root);
        int[] nums = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }
        return dfss(nums,0,nums.length - 1);

    }

    private TreeNode dfss(int[] nums, int left, int right) {
        if (right < left){
            return null;
        }
        if (right == left){
            return new TreeNode(nums[left]);
        }
        int mid = left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = null;
        root.right = dfss(nums,mid + 1,right);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
        dfs(root.left);
        temp.add(root.val);
        if (root.right != null)
        dfs(root.right);
    }


}
