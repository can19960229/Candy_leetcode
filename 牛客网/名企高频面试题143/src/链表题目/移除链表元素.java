package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/5 22:19
 *
 * @Classname 移除链表元素
 * Description: 测试
 */

/**
 *
 */
public class 移除链表元素 {
   public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while( cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
