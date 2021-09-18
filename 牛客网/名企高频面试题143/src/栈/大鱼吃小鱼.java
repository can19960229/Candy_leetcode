package 栈;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/18 22:40
 *
 * @Classname 大鱼吃小鱼
 * Description: 测试
 */

import java.util.Stack;

/**
 *
 */
public class 大鱼吃小鱼 {
    public int solution(int[] fishSize,int[] fishDirection){
        final int fishNumber = fishSize.length;
        if (fishNumber <= 1){
            return fishNumber;
        }
        //0表示鱼向左游
        final int left = 0;
        //1表示鱼向右游
        final int right = 1;
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < fishNumber; i++) {
            final int curFishDirection = fishDirection[i];
            final int curFishSize = fishSize[i];
            //标志当前鱼是否被栈中的鱼吃掉了
            boolean hasEat = false;
            //如果栈中还有鱼，并且栈中鱼向右，当前鱼向左游，那么就会有相遇的可能性
            while (!t.isEmpty() && fishDirection[t.peek()] == right && curFishDirection == left){
                if (fishSize[t.peek()] > curFishSize){
                    hasEat = true;
                    break;
                }
                t.pop();
            }
            //如果新来的鱼没有被吃掉，那么压入栈中
            if (!hasEat){
                t.push(i);
            }

        }
        return t.size();
    }
}
