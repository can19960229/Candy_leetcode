package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/16 16:31
 *
 * @Classname 第一个错误的版本号
 * Description: 测试
 */

/**
 *
 */
public class 第一个错误的版本号 {
    public int firstBanVersion(int n){
        int left = 1,right = n;
        while (left < right){
            int mid = left + ( right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
