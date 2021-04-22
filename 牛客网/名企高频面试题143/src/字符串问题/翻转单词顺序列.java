package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 14:44
 *
 * @Classname 翻转单词顺序列
 * Description: 测试
 */

/**
 *
 */
public class 翻转单词顺序列 {

    //这个答案没有处理字符串中空格为两个的情况,不能AC

    public String reverseWord(String s){
        if (s.trim().length() == 0){
            return s.trim();
        }
        String[] temp = s.trim().split(" ");
        String res = "";
        for (int i = temp.length - 1;i > 0;i--){
            res += temp[i] + " ";
        }
        return res + temp[0];
    }

    public String reverseWord_1(String s) {
        StringBuilder sb = trimSpaces(s);
        //反转字符串
        reverse(sb,0,sb.length() - 1);
        //翻转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    private StringBuilder trimSpaces(String s) {
        int left = 0,right = s.length() - 1;
        //去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ')
            ++left;
        while (left <= right && s.charAt(right) == ' ')
            --right;
        //将字符串间的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                sb.append(c);
            }else if (sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }


    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }
    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0,end = 0;
        while (start < n){
            //循环至单词的末尾
            while (end < n && sb.charAt(end) != ' '){
                ++end;
            }
            //翻转单词
            reverse(sb,start,end - 1);
            //更新start,去找下一个单词
            start = end + 1;
            ++end;
        }
    }


}
