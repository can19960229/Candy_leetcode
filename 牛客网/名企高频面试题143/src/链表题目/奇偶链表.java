package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/6 9:49
 *
 * @Classname 奇偶链表
 * Description: 测试
 */

import com.sun.org.apache.regexp.internal.RE;

/**
 *
 */
public class 奇偶链表 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode oddEventList(ListNode head){
        if(head == null)
            return head;

        ListNode ouHead = head.next;
        ListNode ji = head;
        ListNode ou = head.next;
        while (ji.next != null){
            ji.next = ouHead.next;
            ji = ji.next;
            ou.next = ji.next;
            ou = ou.next;
        }
        ji.next = ouHead;

        return head;
    }
}
