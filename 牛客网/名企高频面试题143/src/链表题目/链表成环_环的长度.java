package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/24 13:25
 *
 * @Classname 链表成环_环的长度
 * Description: 测试
 */

/**
 *
 */
public class 链表成环_环的长度 {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int getCycleLength(Node head){
        if (head == null){
            return 0;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            while (fast == slow){
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                while (fast != slow){
                    len++;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return len;
            }
        }
        return 0;
    }
}
