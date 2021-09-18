package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/20 20:40
 *
 * @Classname 有效的完全平方数
 * Description: 测试
 */

/**
 *
 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num){
        if (num < 2){
            return true;
        }
        long left = 1,right = num / 2, x, guessSquared;
        while (left <= right){
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num){
                return true;
            }
            if (guessSquared > num){
                right = x - 1;
            }else {
                left = x + 1;
            }
        }
        return false;
    }
}
