package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/2 21:01
 *
 * @Classname 最小高度树
 * Description: 测试
 */

/**
 *
 */
public class 最小高度树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums,0,nums.length - 1);
    }
    public TreeNode dfs(int[] nums,int left,int right){
        if (right < left)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid - 1);
        root.right = dfs(nums,mid + 1,right);
        return root;
    }

}
