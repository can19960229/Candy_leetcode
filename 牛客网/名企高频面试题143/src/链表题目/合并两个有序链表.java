package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/6 11:40
 *
 * @Classname 合并两个有序链表
 * Description: 测试
 */

/**
 *
 */
public class 合并两个有序链表 {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while( l1 != null && l2 != null){
            if(l1.val <= l2.val){

                cur.next = l1;
                l1 = l1.next;
            }else{

                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

        }
        if(l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        // cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
