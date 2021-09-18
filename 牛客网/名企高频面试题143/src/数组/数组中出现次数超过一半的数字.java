package 数组;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/8/13 17:30
 *
 * @Classname 数组中出现次数超过一半的数字
 * Description: 测试
 */

import java.util.Scanner;

/**
 * 思路：如果我们把众数记为 +1+1+1，把其他数记为 −1-1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
 */
public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums){
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            if(nums[i] == candidate){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int[] coins = new int[3];
        for (int i = 0; i < str.length; i++) {
            coins[i] = Integer.parseInt(str[i]);
        }

    }
}
