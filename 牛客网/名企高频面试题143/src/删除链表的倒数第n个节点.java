/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/29 22:30
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 删除链表的倒数第n个节点 {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre,end = pre;
        while(n != 0){
            start = start.next;
            n--;
        }
        while(start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
