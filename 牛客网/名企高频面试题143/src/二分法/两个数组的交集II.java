package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/25 14:46
 *
 * @Classname 两个数组的交集II
 * Description: 测试
 */

import java.util.*;

/**
 *
 */
public class 两个数组的交集II {
    public int[] intersect(int[] nums1,int[] nums2){
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)){
                list2.add(num);
                //从list1除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int h = 0;
        for (Integer i : list2) {
            res[h++] = i;
        }
        return res;
    }
}
