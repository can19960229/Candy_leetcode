//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 380 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return null;
        if (head.next == null) return head;

        //闭合链表
        int n;
        ListNode old_tail = head;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        //找到新的头节点，新的尾节点
        //新的头节点 ： （n - k % n - 1）;新的尾节点： （n- k % n）
        ListNode new_tail = head;
        for (int i = 0; i < n - k%n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        //打破闭合链表
        new_tail.next = null;

        return new_head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
