package 链表题目; /**
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

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    /**
     * 双指针解法
     * 第一个指针先走k步，第二个指针再走
     * @param head
     * @param k
     * @return
     */
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

    /**
     *
     * 先计算节点数n，再取第n-k个节点
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail_1 (ListNode pHead, int k) {
        // write code here

        ListNode res = pHead;
        int count = 0;
        while(pHead != null){
            pHead = pHead.next;
            count++;
        }
        if(count < k) return null;
        for(int i = 0;i < count - k;i++){
            res = res.next;
        }
        return res;
    }

}
