package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/29 9:46
 *
 * @Classname 删除二叉搜索树中的节点
 * Description: 测试
 */

/**
 *
 */
public class 删除二叉搜索树中的节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //successor代表中序遍历序列的下一个节点，即比当前节点大的最小节点，称为后继节点。
    //先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空，则指向的节点为后继节点
    public int successor(TreeNode root){
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }
    //Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。
    // 先取当前节点的左节点，然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。

    public int predecessor(TreeNode root){
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }
    //删除节点
    public TreeNode deleteNode(TreeNode root,int key){

        if(root == null)
            return null;
        //说明要删除的节点在右子树，则删除节点
        if (key > root.val)
            root.right = deleteNode(root.right,key);
        //说明要删除的节点在左节点，则删除节点
        else if (key < root.val)
            root.left = deleteNode(root.left,key);
        //该节点就是我们要删除的节点
        else {
            //要删除的节点为叶子节点，可以直接删除。
            if(root.left == null && root.right == null)
                root = null;
            //要删除的节点不是叶子节点且拥有右节点，则该节点可以由该节点的后继节点进行替代，该后继节点位于右子树中较低的位置。
            // 然后可以从后继节点的位置递归向下操作以删除后继节点。
            else if(root.right != null){
                root.val = successor(root);
                //删除后继节点
                root.right = deleteNode(root.right,root.val);
            }
            //要删除的节点不是叶子节点，且没有右节点但是有左节点。这意味着它的后继节点在它的上面，但是我们并不想返回。
            // 我们可以使用它的前驱节点进行替代，然后再递归的向下删除前驱节点。
            else {
                root.val = predecessor(root);
                //删除前驱节点
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }
}
