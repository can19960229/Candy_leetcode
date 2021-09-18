package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/15 11:25
 *
 * @Classname 链表的归并排序
 * Description: 测试
 */

/**
 *
 */
public class 链表的归并排序 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergerSort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //获取链表的中间节点
        ListNode mid = getMid(head);
        //把链表从中间拆分开，变成两个链表，head和second两个子链表
        ListNode second = mid.next;
        mid.next = null;

        ListNode left = mergerSort(head);
        ListNode right = mergerSort(second);

        return merger(right,left);


    }

    private ListNode merger(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null){
            if (l2.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null){
            tail.next = l1;
        }
        else {
            tail.next = l2;
        }
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
