package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/23 22:54
 *
 * @Classname 划分链表
 * Description: 测试
 */

/**
 *
 */

public class 划分链表 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition (ListNode head, int x) {
        // write code here
        ListNode preHead1 = new ListNode(0),preHead2 = new ListNode(0);
        ListNode cur1 = preHead1,cur2 = preHead2;
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = preHead2.next;
        cur2.next = null;
        return preHead1.next;
    }
}
