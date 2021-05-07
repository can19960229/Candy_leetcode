package 数组;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/6 9:40
 *
 * @Classname 数组中重复的数字
 * Description: 测试
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 数组中重复的数字 {
    public int duplicate(int[] numbers){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            if (entry.getValue() != 1)
                return entry.getKey();
        return -1;
    }
}
