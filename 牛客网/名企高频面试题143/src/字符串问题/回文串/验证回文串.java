package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/19 11:12
 *
 * @Classname 验证回文串
 * Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 */

/**
 *
 */
public class 验证回文串 {
    /*
    将字符串反转后比对
     */
    public static boolean isPalindrome_1(String s) {
        return new StringBuilder(s).reverse().equals(s);
    }
    /*
    使用两个指针，从字符串的前后两个方向，向内夹
     */
    public boolean isPalindrome_2(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            //通过 isLetterOrDigit() 可以直接判断当前字符是不是只属于字母和数字。
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j)))
                return false;
            i++; j--;
        }
        return true;
    }

}
