package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 10:22
 *
 * @Classname 把字符串换成整数
 * Description: 来着剑指offer
 */

/**
 *
 */
public class 把字符串换成整数 {
    public int StrToInt(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0;i <str.length();i++){
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')){
                continue;
            }
            if (c < '0' || c > '9')
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
