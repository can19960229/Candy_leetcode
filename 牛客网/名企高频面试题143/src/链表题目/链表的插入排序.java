package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/15 9:59
 *
 * @Classname 链表的插入排序
 * Description: 测试
 */

/**
 *
 */
public class 链表的插入排序 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode insertSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;//pre指向已经有序的节点
        ListNode cur = head.next;//cur指向待排序的节点
        ListNode aux = new ListNode(-1);//辅助节点
        aux.next = head;
        while (cur != null){
            if (cur.val < pre.val){
                pre.next = cur.next;  //先把cur节点从当前链表中删除，然后把cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while (cur.val > l2.val){
                    l1 = l2;
                    l2 = l2.next;
                }
                l1.next = cur;
                cur.next = l2;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }
}
