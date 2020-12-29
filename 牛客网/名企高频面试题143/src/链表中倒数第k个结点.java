/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/29 22:29
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 链表中倒数第k个结点 {
    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i<k;i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
