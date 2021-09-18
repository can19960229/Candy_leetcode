package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/16 17:06
 *
 * @Classname 寻找峰值
 * Description: 测试
 */

/**
 *
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums){
        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = left +(right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
