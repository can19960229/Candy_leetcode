/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/28 20:21
 * version 1.0
 * Description: 测试
 */

import java.util.HashMap;

/**
 *
 */
public class 最长无重复字符子串 {
    public int maxLength(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for (int start = 0,end = 0;end < arr.length;end ++){
            if (map.containsKey(arr[end])){
                //重复的数字的索引可能比start小
                start = Math.max(start,map.get(arr[end]) + 1);
            }
            max = Math.max(max,end - start + 1);
            map.put(arr[end],end);
        }
        return max;
    }
}
