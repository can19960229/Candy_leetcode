package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 22:13
 *
 * @Classname 重排链表
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 重排链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();

    }
}
