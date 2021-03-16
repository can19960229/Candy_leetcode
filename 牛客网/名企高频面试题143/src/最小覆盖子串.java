/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/16 19:11
 *
 * @Classname 最小覆盖子串
 * Description: 测试
 */

import java.util.HashMap;

/**
 *
 */
public class 最小覆盖子串 {
    /**
     * 这道题的思路是：
     * 1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符。
     * 记录窗口长度d
     * 2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被
     * 包含在窗口，
     * 3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
     * 4) 如此循环知道end到S中的最后一个字符。
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S,String T){
        int[] map = new int[128];
        //记录T中每个元素出现的次数
        for (int i = 0; i < T.length(); i++) {
            map[T.charAt(i)]++;
        }
        int begin = 0,end = 0,d = Integer.MAX_VALUE,counter = T.length(),head = 0;
        //end指针一直向后遍历
        while (end < S.length()){
            //map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符包含在窗口，counter--,如果s中的字符没有在T中出现，则map[] 中对应的字符-1后变为负数
            if (map[S.charAt(end++)]-- > 0){
                counter--;//出现了则T中的字符长度减1
            }
            //当counter == 0时，说明窗口已经包含了T中所有字符
            while (counter == 0){
                if (end - begin <d){//更新窗口长度
                    head = begin;
                    d = end  - head;
                }
                // begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
                if (map[S.charAt(begin++)] ++ == 0){
                    counter++;// 在T中的某个字符从窗口中移除，所以counter++。
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : S.substring(head,head + d);
    }
}
