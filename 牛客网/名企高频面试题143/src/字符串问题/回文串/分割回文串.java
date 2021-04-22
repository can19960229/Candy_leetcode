package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 9:44
 *
 * @Classname 分割回文串
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 */
public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s){
        if (s == null ||s.length() == 0){
            return res;
        }
        dfs(s,new ArrayList<String>(),0);
        return res;
    }

    private void dfs(String s, ArrayList<String> remain, int left) {
        if (left == s.length()){//判断终止条件
            res.add(new ArrayList<>(remain));
            return;
        }
        for (int right = left;right < s.length();right++){//从left开始，依次判断left->right是不是回文串
            if (isPalindroom(s,left,right)){//判断是否是回文串
                remain.add(s.substring(left,right+1));//添加到当前回文串到list中
                dfs(s,remain,right+1);//从right+1开始继续递归，寻找回文串
                remain.remove(remain.size() - 1);//回溯，从而寻找更长的回文串
            }
        }
    }

    /**
     * 判断是否是回文串
     */
    private boolean isPalindroom(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }
}
