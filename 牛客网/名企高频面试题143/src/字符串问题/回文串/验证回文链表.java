package 字符串问题.回文串;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/19 9:47
 *
 * @Classname 验证回文链表
 * Description: 测试
 */



/**
 * 单链表这种特殊的结构，想要确定个长度也需要 O(n) 的复杂度，而且没有前驱指针，双指针前后夹的办法是没法用了。
 */
public class 验证回文链表 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    /*
    我们可以通过快慢指针的方式找到链表的中间节点，然后再将原链表的一半反转，之后开始比对。
    第一遍循环之后，slow 节点指向了链表的中间位置，而 pre 则是翻转了原链表的前半部分的子链表。

    再通过一个 while 循环，将它们逐个比对，就可以得到我们要的结果。
     */
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head,prepre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //如果fast不为null，说明是奇数，需要再进一位
        if (fast != null){
            slow = slow.next;
        }
        //此时pre为反转原链表前半部分的子链表
        //slow为原链表的中间节点
        while (pre != null && slow != null){
            if (pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }


}
