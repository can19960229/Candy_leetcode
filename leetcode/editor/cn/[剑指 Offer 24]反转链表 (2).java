//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_24 {
    //迭代
    public ListNode reverseList_1(ListNode head) {
        ListNode cur = head,pre = null;
        while (cur != null){
            ListNode temp = cur.next;  //暂存后继节点cur.next
            cur.next = pre; //修改next引用指向
            pre = cur;  //pre暂存cur
            cur = temp;  //cur访问下一节点
        }
        return pre;
    }

    //递归
    public ListNode reverseList(ListNode head){
        return recur(head,null);  //调用递归并返回
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, pre);  //递归后继节点
        cur.next = pre;  //修改节点应用指向
        return res;  //返回反转链表的头节点
    }

}
//leetcode submit region end(Prohibit modification and deletion)
