package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/20 21:41
 *
 * @Classname 两个数组的交集
 * Description: 测试
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 两个数组的交集 {
    public static int[] intersection(int[] nums1,int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            map1.put(nums2[i],map.getOrDefault(nums2[i],0) + 1);
        }
        int[] temp = new int[len1 + len2 + 2];
        int i = 0;
        for (Integer key1 : map1.keySet()) {
            if (map.containsKey(key1)){
                System.out.println(key1);
                temp[i] = key1;
                System.out.println(temp[i]);
                i++;
            }
        }
        return Arrays.copyOfRange(temp,0,i);
    }

    public static void main(String[] args) {
        intersection(new int[]{1},new int[]{1});
    }
}
