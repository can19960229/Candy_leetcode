package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/8/6 20:43
 *
 * @Classname 删除排序数组中的重复项II
 * Description: 测试
 */

/**
 *
 */
public class 删除排序数组中的重复项II {
    public int removeDuplicates(int[] nums){
        int n = nums.length;
        if (n <= 2){
            return n;
        }
        int slow = 2,fast = 2;
        while (fast < n){
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public int remove(int[] nums){
        if (nums.length <= 2){
            return nums.length;
        }
       int slow = 2;
       int fast = 2;
       while (fast < nums.length){
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
       }
       return slow;
    }
}
