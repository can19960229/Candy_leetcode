package 字符串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/6 10:05
 *
 * @Classname 替换空格
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 替换空格 {
    public String replaceSpace(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ')
                count++;
        }
        int[] temp = new int[s.length() + count * 2];
        int index = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                temp[index] = '%';
                temp[index++] = '2';
                temp[index++] = '0';
            } else {
                temp[index++] = aChar;
            }
        }
        return new String(temp,0,temp.length);
    }
}
