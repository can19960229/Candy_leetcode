package 十大排序;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/25 10:53
 *
 * @Classname 选择排序
 * Description: 测试
 */

/**
 *
 */
public class 选择排序 {

    public int[] sortArray(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i +1; j < len; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
    }
}
