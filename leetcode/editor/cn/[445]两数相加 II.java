//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 349 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_445 {
    /**
     * 使用栈，可以把链表的头尾进行调换
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        //创建头节点
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int flag = 0; //记录进位

        while (!s1.isEmpty() || !s2.isEmpty() || flag > 0){
            int sum = flag;
            if (!s1.isEmpty())
                sum = sum + s1.pop();
            if (!s2.isEmpty())
                sum = sum + s2.pop();

            flag = sum / 10; //进位



            ListNode tmp = new ListNode(sum % 10);
            tmp.next = head.next;
            head.next = tmp;


        }


        return head.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
