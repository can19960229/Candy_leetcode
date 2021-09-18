package org.example;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/18 11:39
 *
 * @Classname test
 * Description: 测试
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 */
public class 按照频率将数组升序排序 {
    //hashMap,不考虑负数的情况
    public static int[] frequencySort2(int[] nums) {
        // 计算每个元素出现的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        // 进行排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.get(nums[i]) > map.get(nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                if (map.get(nums[i]) == map.get(nums[j]) && nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    //
    public int[] frequencySort3(int[] nums){
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer)nums[i];
        }
        System.out.println(Arrays.toString(array));
        //计算每个元素出现的频率
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        //进行排序
        //如果频率相同，就按照数值排序；如果频率不同，就按照频率大小升序排列
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1).equals(map.get(o2))){
                    return o2 - o1;
                }
                return (int)map.get(o1) - map.get(o2);
            }
        });
        for (int i = 0; i < array.length; i++) {
            nums[i] = (int)array[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort2(new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 4})));
    }
}
