package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/1 14:01
 *
 * @Classname 链表中的节点每k个一组翻转
 * Description: 测试
 */

/**
 *
 */
public class 链表中的节点每k个一组翻转 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverseKGroup(ListNode head,int k){
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy,curr = head,temp;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k;i++){
            for (int j = 1;j < k;j++){
                temp = curr.next;
                curr.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
