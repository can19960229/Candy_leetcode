package 栈.单调栈;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/18 23:10
 *
 * @Classname 字典序最小的k个数的子序列
 * Description: 测试
 */

import java.util.Stack;

/**
 *
 */
public class 字典序最小的k个数的子序列 {
    public int[] findSmallSeq(int[] nums,int k){
        int[] ans = new int[k];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final int left = nums.length - i;
            while (!s.isEmpty() && (s.size() + left > k) && s.peek() > x){
                s.pop();
            }
            s.push(x);
        }
        while (s.size() > k){
            s.pop();
        }
        for (int i = k - 1;i >= 0;i--){
            ans[i] = s.peek();
            s.pop();
        }
        return ans;
    }
}
