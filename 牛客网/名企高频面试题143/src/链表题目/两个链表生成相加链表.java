package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/14 23:16
 *
 * @Classname 两个链表生成相加链表
 * Description: 测试
 */

import java.util.Stack;

/**
 * 利用三个栈模拟两个链表相加，第一个栈存第一个链表的头到尾节点，第二个链表存第二个链表的头到尾节点，由于节点的进位指向头节点，等到两个栈存完节点后取出相加，保留进位，
 * 可以把进位随着栈的取出到达前一个节点，把前两个栈取出的值和进位值相加得到的值重新创一个新的ListNode节点存入第三个栈，
 * 当前两个栈都取空的时候，第三个栈的节点循环取出重构链表即可得到结果
 */
public class 两个链表生成相加链表 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addInList_1(ListNode head1,ListNode head2){
        Stack<ListNode> stack1 = new Stack<>();  //存第一个链表的节点
        Stack<ListNode> stack2 = new Stack<>();  //存第二个链表的节点
        Stack<ListNode> stack3 = new Stack<>();  //存相加后链表的节点
        ListNode tail = new ListNode(0);
        ListNode result = tail;
        if (head1 == null || head2 == null){
            if (head1 == null)
                return head2;
            else return head1;
        }
        while (head1 != null){
            stack1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null){
            stack2.add(head2);
            head2 = head2.next;
        }
        int val1=0;   //存第一个栈取出的值
        int val2=0;   //存第二个栈取出的值
        int sum =0;   //存val1,val2，next的和
        int next=0;   //定义进位值并初始化
        while (!stack1.empty()||!stack2.empty()){
            if (!stack1.empty()&&!stack2.empty()){
                val1=stack1.pop().val;
                val2=stack2.pop().val;
                sum=val1+val2+next;
                int val=sum%10;
                stack3.push(new ListNode(val));
                next=sum/10;
            }
            if (!stack1.empty()&&stack2.empty()){
                val1=stack1.pop().val;
                sum=val1+next;
                int val=sum%10;
                stack3.push(new ListNode(val));
                next=sum/10;
            }
            if (stack1.empty()&&!stack2.empty()){
                val2=stack2.pop().val;
                sum=val2+next;
                int val=sum%10;
                stack3.push(new ListNode(val));
                next=sum/10;
            }
        }
        while (!stack3.empty()){
            tail.next= new ListNode(stack3.pop().val);
            tail=tail.next;
        }
        return result.next;
    }

    public ListNode addInList(ListNode head1,ListNode head2) {
        ListNode p1 = Ref(head1);
        ListNode  p2 = Ref(head2);
        ListNode  head = new ListNode(0);
        int flag = 0;
        while(p1!=null&&p2!=null){
            head.val = (p1.val + p2.val + flag)%10;
            flag = (p1.val + p2.val + flag)/10;
            ListNode temp = new ListNode(0);
            temp.next = head;
            head = temp;
            p1 = p1.next;
            p2=p2.next;
        }
        if(p1==null) {
            while(p2!=null){
                int num = p2.val+flag;
                head.val = num%10;
                flag = num/10;
                ListNode temp = new ListNode(0);
                temp.next = head;
                head = temp;
                p2=p2.next;
            }
        }
        if(p2==null) {
            while(p1!=null){
                int num = p1.val+flag;
                head.val = num%10;
                flag = num/10;
                ListNode temp = new ListNode(0);
                temp.next = head;
                head = temp;
                p1=p1.next;
            }
        }
        if(flag==0) return head.next;
        head.val = flag;
        return head;
    }

    private ListNode Ref(ListNode head) {
        if (head == null)
            return head;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;
        p2 = head;
        p3 = p2.next;
        while (p2 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p2 != null)p3 = p3.next;
        }
        return p1;
    }

}
