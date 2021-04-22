package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 10:27
 *
 * @Classname 最长公共前缀
 * Description: 测试
 */

import java.util.Arrays;

/**
 * 首先对字符串数组进行排序，然后拿数组中的第一个和最后一个字符串进行比较，从第 0 位开始，如果相同，把它加入 res 中，不同则退出。最后返回 res
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        StringBuffer res = new StringBuffer();
        int len = Math.min(first.length, last.length);
        int i = 0;
        while (i < len){
            if (first[i] == last[i]) {
                res.append(first[i]);
                i++;
            }
            else
                break;
        }
        return res.toString();
    }
}
