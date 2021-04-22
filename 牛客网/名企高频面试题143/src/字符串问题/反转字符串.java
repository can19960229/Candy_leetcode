package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 10:19
 *
 * @Classname 反转字符串
 * Description: 测试
 */

/**
 *
 */
public class 反转字符串 {
    public void reverseString(char[] s){
        int i=0;
        int j=s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
