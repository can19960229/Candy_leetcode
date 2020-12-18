//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution_589 {
    /*
}
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root,res);
        return res;
    }
    private void helper(Node root,List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            helper(node,res);
        }
    }
    */
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = new Node();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node No : node.children) {
                stack.add(No);
            }
        }
        return output;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
