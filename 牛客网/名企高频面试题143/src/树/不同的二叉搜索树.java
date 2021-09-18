package 树;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/26 19:47
 *
 * @Classname 不同的二叉搜索树
 * Description: 测试
 */

import org.omg.PortableInterceptor.INACTIVE;

/**
 *
 */
public class 不同的二叉搜索树 {
    //动态规划
    public int numTrees(int n){
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2;i <= n;i++){
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
