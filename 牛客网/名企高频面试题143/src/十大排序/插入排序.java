package 十大排序;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/25 10:57
 *
 * @Classname 插入排序
 * Description: 测试
 */


/**
 *
 */
public class 插入排序 {
    public int[] sortArray(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j -1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;

    }
}
