/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/21 9:48
 *
 * @Classname 二叉搜索树
 * Description: 测试
 */

/**
 * 二叉搜索树的后序遍历——————判断一个数组是不是二叉搜索树的后序遍历
 */
public class 二叉搜索树 {
    public boolean verifyPostorder(int[] postorder) {
        return cur(postorder,0,postorder.length - 1);
    }
    public boolean cur(int[] postorder,int i,int j){
        if(i >= j) return true;  //当节点数≤1，无需判别正确性，直接返回true
        int root = postorder[j];
        int p = i;
        while(postorder[p] < root){
            p++;
        }
        int m = p;
        while(postorder[p] > root){
            p++;
        }
        return p == j && cur(postorder,i,m - 1) && cur(postorder,m,j - 1);
    }
}
