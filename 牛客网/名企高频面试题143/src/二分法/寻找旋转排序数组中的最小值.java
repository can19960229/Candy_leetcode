package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/18 15:09
 *
 * @Classname 寻找旋转排序数组中的最小值
 * Description: 测试
 */

/**
 *
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
