package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/6 10:45
 *
 * @Classname 回文链表
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 回文链表 {
    public class ListNode{
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
        public boolean isP(ListNode head){
            if (head == null || head.next == null)
                return true;
            List<Integer> rval = new ArrayList<>();
            while(head.next != null){
                rval.add(head.val);
                head = head.next;
            }
            int left = 0;
            int right = rval.size() - 1;
            while (left < right){
                if (!rval.get(left).equals(rval.get(right))){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
