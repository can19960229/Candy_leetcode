package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 15:16
 *
 * @Classname 字符流中第一个不重复的字符
 * Description: 测试
 */

import java.util.HashMap;

/**
 * 例如，
 * 当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是”g”。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是”l”。
 */
public class 字符流中第一个不重复的字符 {
    HashMap<Character,Integer> map = new HashMap<>();
    StringBuffer s = new StringBuffer();
    public void Insert(char ch){
        s.append(ch);
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch) + 1);
        }else {
            map.put(ch,1);
        }
    }
    public char FirstAppearOnce(){
        for (int i = 0;i < s.length();i++){
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return '#';
    }
}
