package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/18 16:56
 *
 * @Classname 在排序数组中查找元素的第一个和最后一个位置
 * Description: 测试
 */

/**
 *
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
       int left = left_b(nums,target);
       int right = right_b(nums,target);
       int[] a = {left,right};
       return a;
    }

    private int right_b(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left +(right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] == target){
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    private int left_b(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] < target){
                left = mid +1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] == target){
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

}
