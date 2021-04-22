package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 11:38
 *
 * @Classname 第一个只出现一次的字符
 * Description: 测试
 */

import java.util.HashMap;

/**
 *
 */
public class 第一个只出现一次的字符 {
    public int test(String str){
        int len = str.length();
        if (len == 0)
            return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < len; i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    //使用数组进行字符串出现次数的统计，出现则进行加一
    public char test_1(String s){
        int [] mp = new int[128];
        for (int i = 0; i < s.length(); i++) {
            mp[s.charAt(i)]++;

        }
        for (int i = 0; i < s.length(); i++) {
            if( mp[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
