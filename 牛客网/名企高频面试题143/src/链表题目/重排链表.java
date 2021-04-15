package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 22:13
 *
 * @Classname 重排链表
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 重排链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList_1(ListNode head) {
        if (head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>(); //ArrayList为线性表
        //将链表的每一个节点依次存进ArrayList中
        while (head != null){
            list.add(head);
            head = head.next;
        }
        //两个之正依次向前，后进行遍历取元素
        int i = 0,j = list.size() - 1;
        while (i < j){
            //1->2->3->4
            //前面的节点的下一个节点指向最后的节点
            list.get(i).next = list.get(j);  //1->4
            i++;  //此时i++ ,则此时list.get(i)为原来前面节点的下一个节点  即节点2
            if(i == j)  //若链表长度为偶数的情况下，则会提前相遇，则终止循环
                break;
            list.get(j).next = list.get(i);  // 4->2
            //此时变为 1->4->2->
            j--;
        }
        list.get(i).next = null; // 最后一个节点的下一个节点为null
    }

    /**
     * 方法二：三步走
     * eg： 1->2->3->4->5->6
     *
     * 第一步：将链表分为两个链表
     *
     * ​ 1->2->3 4->5->6
     *
     * 第二步：将第二个链表逆序
     *
     * ​ 1->2->3 6->5->4
     *
     * 第三步：依次连接两个链表 连接形式如下
     *
     * ​ 1->6->2->5->3->4
     */
    public void reorderList(ListNode head){
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;  //将链表一分为二
        ListNode newHead = reverse(mid);    //反转链表

        while (newHead != null){  //反转后将两个链表进行合并
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }


}
