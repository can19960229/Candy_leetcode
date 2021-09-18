package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/4 22:59
 *
 * @Classname 删除链表的倒数第k个节点
 * Description: 测试
 */

/**
 *
 */
public class 删除链表的倒数第k个节点 {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return null;
        }
        if(head != null && head.next == null && n == 1){
            return null;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
