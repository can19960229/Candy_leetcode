package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/8 11:14
 *
 * @Classname 相交链表
 * Description: 测试
 */

/**
 *
 */
public class 相交链表 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2){
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
