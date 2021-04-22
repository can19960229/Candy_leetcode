package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 15:11
 *
 * @Classname 左旋转字符串
 * Description: 测试
 */

/**
 *
 */
public class 左旋转字符串 {
    //在第 n 个字符后面将切一刀，将字符串分为两部分，再重新并接起来即可。注意字符串长度为 0 的情况。
    public String leftRotateString(String str,int n){
        int len = str.length();
        if (len == 0)
            return "";
        n = n % len;
        String s1 = str.substring(n,len);
        String s2 = str.substring(0,n);
        return s1 + s2;
    }
}
