/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/23 9:27
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 翻转链表_ {
    public ListNode ReverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = null;
        while (head != null){
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }
}
