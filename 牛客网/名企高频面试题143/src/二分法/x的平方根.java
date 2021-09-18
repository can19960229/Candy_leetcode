package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/14 9:29
 *
 * @Classname x的平方根
 * Description: 测试
 */

/**
 *
 */
public class x的平方根 {
    public int mySqrt(int x){
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int left = 1;
        int right = x / 2;
        while (left < right){
            int mid = left + ( right - left + 1) / 2;
            if (mid > x / mid){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }



    public int sqrt(int x){
        int l = 1,r = x,ans = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
