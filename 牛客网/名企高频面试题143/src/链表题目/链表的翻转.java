package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/9 10:26
 *
 * @Classname 链表的翻转
 * Description: 测试
 */

import java.util.LinkedList;

/**
 *
 */
public class 链表的翻转 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre.next = curr;
            curr.next = temp;
        }
        return pre;
    }
}
