//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

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
class Solution_23 {
    //方法一：将链表进行两两合并，顺序合并
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeKTwoLists(ans,lists[i]);
        }
        return ans;
    }
    //方法二：并归，分而治之
    public ListNode mergeKLists2(ListNode[] lists){
        return merge(lists,0,lists.length - 1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if (l == r){
            return lists[l];
        }
        if (l > r)
            return null;
        int mid = (l + r) >> 1;
        return mergeKTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    //合并两个链表
    private ListNode mergeKTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode tail = head,aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }

        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    //方法三
    //k指针：k个指针分别指向k条链表
    public ListNode mergeKLists3(ListNode[] lists){
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true){
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0;i < k;i++){
                if (lists[i] == null){
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val){
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1){
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    //方法四：
    //小根堆，优先队列实现小根堆
    public ListNode mergeKLists(ListNode[] lists){
        //先把所有节点都加入优先队列中，加入后节点是有顺序的
        Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            ListNode min = pq.poll();
            cur.next = min;
            cur = min;
            if (min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
