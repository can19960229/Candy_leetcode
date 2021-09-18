package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/26 22:03
 *
 * @Classname 寻找重复数
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 寻找重复数 {
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        while(left < nums.length - 1){
            if(nums[left] == nums[left + 1]){
                return nums[left];
            }
            left++;
        }
        return -1;
    }

    public int findDuplicate2(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for(int i = 0;i <= right;i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
