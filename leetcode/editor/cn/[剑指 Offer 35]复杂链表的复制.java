//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 132 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution_35_1 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<Node,Node>();
        //3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null){
            //存储put:<key,value1>
            map.put(cur,new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur = cur.next;
        }
        cur = head;
        //4. 构建新链表的next和random指向
        while (cur != null){
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next);//新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random);//新结点random指向同旧结点的random指向
            cur = cur.next;
        }
        //5.返回新链表的头节点
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
