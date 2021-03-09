package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/9 10:53
 *
 * @Classname 链表是否有环
 * Description: 测试
 */

import java.util.List;

/**
 *
 */
public class 链表是否有环 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断链表是否成环
     * @param head
     * @return
     */
    public boolean cycle(ListNode head){
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                //相遇处就是环的入口节点
                return fast;
            }
        }
        //表示没有环
        return null;
    }
}
