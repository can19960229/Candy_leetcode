package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/15 22:55
 *
 * @Classname 旋转字符串
 * Description: 测试
 */

/**
 *
 */
public class 旋转字符串 {
    //利用java中的API进行判断旋转字符串
    public boolean solve_1 (String A, String B) {
        // write code here
        if (A.length() != B.length())
            return false;
        return (A + A).contains(B);
    }
    //自己反转字符串进行判断
    public boolean solve(String A,String B){
        if (A.length() != B.length()){
            return false;
        }
        if (A.equals(B)){
            return true;
        }
        for (int i = 1;i < A.length();i++){
            String reverseStr = reverse(A,i);
            if (reverseStr.equals(B)){
                return true;
            }
        }
        return false;
    }

    private String reverse(String s, int num) {
        char[] chars = s.toCharArray();
        helper(chars,0,num);
        helper(chars,num+1,s.length() - 1);
        helper(chars,0,s.length() - 1);
        return String.valueOf(chars);
    }

    private void helper(char[] chars, int start, int end) {
        while (start < end){
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }

}
