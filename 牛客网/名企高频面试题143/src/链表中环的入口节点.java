/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/28 20:52
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 链表中环的入口节点 {
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){    //利用快慢指针找相遇点
                ListNode slow2 = head;    //设置以相同的新指针从起始位置出发
                while(slow2 != slow){    //未相遇循环
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
