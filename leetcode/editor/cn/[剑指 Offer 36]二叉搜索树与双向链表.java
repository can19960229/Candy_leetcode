//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 201 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
/*
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution_36_1 {


    /*
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedBlockingDeque<>();
        //中序遍历得到递增队列
        queue = dfs(root,queue);

        //先将第一个节点pop出来，方便操作
        Node head = queue.remove();
        Node pre = head;
        Node cur = head;
        while (!queue.isEmpty()){
            cur = queue.remove();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    private Queue<Node> dfs(Node root, Queue<Node> queue) {
        if (root == null)
            return null;
        dfs(root.left,queue);
        queue.add(root);
        dfs(root.right,queue);
        return queue;
    }

*/
}


//leetcode submit region end(Prohibit modification and deletion)
