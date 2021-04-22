package 字符串问题;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 10:23
 *
 * @Classname 替换空格
 * Description: 测试
 */

/**
 *
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str){
        StringBuilder sb = new StringBuilder();
        int len = str.length() - 1;
        //从后往前遍历，找到空格就往里添加“%20”,不然就添加字符串的该位，然后将字符串进行反转并输出
        for (int i = len; i >= 0; i--) {
            if (str.charAt(i) == ' ')
                sb.append("02%");
            else
                sb.append(str.charAt(i));
        }
        return sb.reverse().toString();
    }
}
