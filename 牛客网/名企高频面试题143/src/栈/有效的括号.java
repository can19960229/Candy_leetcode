package 栈;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/18 11:15
 *
 * @Classname 有效的括号
 * Description: 测试
 */

import java.util.Stack;

/**
 *
 */
public class 有效的括号 {
    public boolean isValid(String s){
        if(s == null || s.length() == 0)
            return false;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                t.push(c);
            }else if (c == ')'){
                if (t.empty() || t.peek() != '('){
                    return false;
                }
                t.pop();
            }else if (c == ']'){
                if (t.empty() || t.peek() != '[')
                    return false;
                t.pop();
            }else if (c == '}'){
                if (t.empty() || t.peek() != '{')
                    return false;
                t.pop();
            }else {
                return false;
            }
        }
        return t.isEmpty();
    }
}
