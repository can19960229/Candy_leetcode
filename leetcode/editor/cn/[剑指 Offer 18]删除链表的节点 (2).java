//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 89 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import sun.plugin.javascript.navig.LinkArray;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_18 {
    public ListNode deleteNode(ListNode head, int val) {
        //初始化一个虚拟节点
        ListNode dummy = new ListNode(0);
        //让虚拟节点指向头节点
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null){
            if (cur.val == val){
                //如果找到要删除的节点，直接删除
                pre.next = cur.next;
                break;
            }
            //没有找到要删除的节点，pre指针和cur指针都同时往后移一步
            pre = cur;
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个节点
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
