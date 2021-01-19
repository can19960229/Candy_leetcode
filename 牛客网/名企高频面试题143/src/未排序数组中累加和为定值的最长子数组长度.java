/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/15 22:39
 * version 1.0
 * Description: 测试
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 未排序数组中累加和为定值的最长子数组长度 {
    /**
     * max length of the subarray sum = k
     * @param arr int整型一维数组 the array
     * @param k int整型 target
     * @return int整型
     */
    public int maxlenEqualK (int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0 ;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)){
                len = Math.max(i = map.get(sum - k),len);
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }

}
