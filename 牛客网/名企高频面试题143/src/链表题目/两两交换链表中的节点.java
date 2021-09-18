package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/8/8 11:32
 *
 * @Classname 两两交换链表中的节点
 * Description: 测试
 */

import java.util.List;

/**
 *
 */
public class 两两交换链表中的节点 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode swap(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null){
            ListNode l1 = temp.next;
            ListNode l2 = temp.next.next;
            temp.next = l2;
            l1.next = l2.next;
            l2.next = l1;
        }
        return dummy.next;
    }
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        temp = arr[low];
        while (i < j){
            while (temp<=arr[j] && i < j){
                j--;
            }
            while (temp>= arr[i] && i < j){
                i++;
            }
            if (i < j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
            arr[low] = arr[i];
            arr[i] = temp;
            quickSort(arr,low,j - 1);
            quickSort(arr,j+1,high);
        }
    }
}
