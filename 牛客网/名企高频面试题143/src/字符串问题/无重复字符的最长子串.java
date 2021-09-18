package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/4 10:16
 *
 * @Classname 无重复字符的最长子串
 * Description: 给定一个字符串，找出其中不含有重复字符的最长子串
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

}
