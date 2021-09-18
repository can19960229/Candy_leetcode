package 链表题目;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/7 11:43
 *
 * @Classname flatten
 * Description: 测试
 */

import java.util.ArrayList;

/**
 *
 */
public class Solution{
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head){
        if(head == null){
            return head;
        }
        Node temp = head;
        ArrayList<Node> arrayList = new ArrayList<>();
        dfs(temp,arrayList);
        if (arrayList.size() > 0){
            for (Node node : arrayList) {
                node.prev = temp;
                node.next = null;
                node.child = null;
                temp.next = node;
                temp = node;
            }
        }
        head.prev = null;
        head.child = null;
        return head;
    }

    private void dfs(Node temp, ArrayList<Node> arrayList) {
        if (temp != null){
            arrayList.add(temp);
            dfs(temp.child,arrayList);
            dfs(temp.next,arrayList);
        }
    }

}
