package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/15 10:30
 *
 * @Classname 合并k个已排序的链表
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class 合并k个已排序的链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * 分治法
     */
    public ListNode mergeKLists_1(ArrayList<ListNode> lists) {
        return merge(lists,0,lists.size() - 1);
    }

    private ListNode merge(ArrayList<ListNode> lists, int l, int r) {
        //左右相等说明不能再分
        if (l == r)
            return lists.get(l);
        if (l > r)
            return null;
        int mid = l +(r - l) / 2;
        return mergeTwoList(merge(lists, l, mid),merge(lists,mid + 1,r));
    }

    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (node1!= null && node2!= null){
            if (node1.val <= node2.val){
                tmp.next = node1;
                node1 = node1.next;
            }else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = node1 != null ? node1:node2;
        return node.next;
    }


    /**
     * 顺序合并
     */
    public ListNode mergeKLists_2(ArrayList<ListNode> lists){
        int n = lists.size();
        if (n == 0)
            return null;
        if (n == 1)
            return lists.get(0);
        ListNode node = lists.get(0);
        for (int i = 1;i < n;i++){
            node = mergeTwoLists(lists.get(i),node);
        }
        return node;
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                tmp.next = node1;
                node1 = node1.next;
            }else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = node1 != null ? node1 : node2;
        return node.next;
    }

    /**
     * 优先队列
     * 当把全部的链表加进去优先队列的时候，优先队列会根据头结点的值对所有链表按照头结点的大小从小到大进行排序
     * 所以优先队列的头都是值最小的那个节点，当取出对头的时候，需要判断此节点的吓一跳是否为null，不为null则需要将其吓一跳加进去优先队列中，
     * 此时优先队列又会按照头结点的大小从小到大排序，然后依次重复原来的过程，直接优先队列为null后停止
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        //小根堆
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        //将全部的节点加进去
        for (ListNode node : lists) {
            if (node != null){
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()){
            //队首为值小的节点
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            //若拿出来的节点的下一个节点不为null，则将其放回去
            if (minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

}
