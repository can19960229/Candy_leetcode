package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/14 22:49
 *
 * @Classname 链表的奇偶重排
 * Description: 测试
 */

/**
 * 维护两个指针，一个指向奇数链表的头，一个指向偶数链表的头
 * 先将链表分为奇数链表和偶数链表，然后再进行合并。
 * 奇数位置的后面必定是偶数，偶数位置后面必定是奇数，利用这个特点即可解决这道题目~
 */
public class 链表的奇偶重排 {
    public static class ListNode {
        int val;
       ListNode next = null;
    }

    public ListNode oddEvenList (ListNode head) {
        if (head == null || head.next == null)
            return head;
        /*
          odd 指向奇数节点的指针
          oddHead 指向初始奇数节点的头指针
          even 指向偶数节点的指针
          evenHead 指向初始偶数节点的头指针
         */
        ListNode odd = head,oddHead = head,even = head.next,evenHead = head.next;
        while (even != null && even.next != null){
            //奇数节点指向偶数节点的next
            odd.next = even.next;
            //奇数节点指针后移
            odd = odd.next;
            //偶数节点指向奇数节点的next
            even.next = odd.next;
            //偶数节点后移
            even = even.next;
        }
        //将奇数节点的next指向偶数节点的初始头指针
        odd.next = evenHead;
        //返回奇数节点的初始头指针
        return oddHead;
    }
}
