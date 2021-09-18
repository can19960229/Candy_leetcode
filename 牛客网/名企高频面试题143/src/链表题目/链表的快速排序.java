package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/15 10:45
 *
 * @Classname 链表的快速排序
 * Description: 测试
 */

/**
 *
 */
public class 链表的快速排序 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode quickSort(ListNode begin,ListNode end){
        //判断为空，判断是不是只有一个节点
        if (begin == null || end == null || begin == end){
            return begin;
        }
        //第一个节点和第一个节点的后面一个节点
        //begin指向的是当前遍历的最后一个<=nMidValue 的节点
        ListNode first = begin;
        ListNode second = begin.next;
        int nMidValue = begin.val;
        //结束条件，second到最后了
        while (second != end.next && second != null){
            if (second.val < nMidValue){
                first = first.next;
                if (first != second){
                    int temp = first.val;
                    first.val =second.val;
                    second.val =temp;
                }
            }
            second = second.next;
        }
        if (begin != first){
            int temp = begin.val;
            begin.val = first.val;
            first.val = temp;
        }
        quickSort(begin,first);
        quickSort(first.next,end);
        return begin;
    }

}
