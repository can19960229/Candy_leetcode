package 栈.单调栈;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/18 22:50
 *
 * @Classname 找出数组中右边比我小的元素
 * Description: 测试
 */

import java.util.Stack;

/**
 * 单调栈
 */
public class 找出数组中右边比我小的元素 {
    public static int[] findRightSmall(int[] A){
        int[] ans = new int[A.length];
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            while (!t.isEmpty() && A[t.peek()] > x){
                ans[t.peek()] = i;
                t.pop();
            }
            t.push(i);
        }
        //
        while (!t.empty()){
            ans[t.peek()] = -1;
            t.pop();
        }
        return ans;
    }
}
