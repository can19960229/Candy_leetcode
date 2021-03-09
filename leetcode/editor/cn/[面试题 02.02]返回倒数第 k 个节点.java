//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 58 👎 0


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
class Solution_02_02 {
    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public int kthToLast_1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 栈  只要把原链表的结点全部压栈，然后再把栈中最上面的k个节点出栈，出栈的结点重新串成一个新的链表即可
     * @param head
     * @param k
     * @return
     */
    public int kthToLast_2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        //链表节点压栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        //在出栈串成新的链表
        ListNode firstNode = stack.pop();
        while (--k > 0){
            ListNode temp = stack.pop();
            temp.next = firstNode;
            firstNode = temp;
        }
        return firstNode.val;
    }

    /**
     * 递归
     */

    int size;
    public int kthToLast(ListNode head, int k) {
        if (head == null)
            return 0;
        int value = kthToLast(head.next,k);
        if (++size == k)
            return head.val;
        return value;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)
