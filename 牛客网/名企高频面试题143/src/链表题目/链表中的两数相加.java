package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/7 10:24
 *
 * @Classname 链表中的两数相加
 * Description: 测试
 */

/**
 *    输入：l1 = [2,4,3], l2 = [5,6,4]
 *    输出：[7,0,8]
 *    解释：342 + 465 = 807.
 */
public class 链表中的两数相加 {
    public static class ListNode{
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode cur = null;
        ListNode head = new ListNode(9);
        cur = head;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(7);

        ListNode cur2 = null;
        ListNode head2 = new ListNode(6);
        cur2 = head2;

    }
}
