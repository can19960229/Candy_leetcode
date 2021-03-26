package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/25 23:24
 *
 * @Classname 链表指定区间反转
 * Description: 测试
 */

/**
 *
 */
public class 链表指定区间反转 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
            this.val = i;
        }
    }

    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        for(int i = 1;i < m;i++){
            preStart = start;
            start = start.next;
        }
        //反转
        for(int i = 0;i < n - m;i++){
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return dummy.next;
    }

}
