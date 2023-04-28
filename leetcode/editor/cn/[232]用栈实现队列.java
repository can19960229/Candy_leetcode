////请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
////
//// 实现 MyQueue 类：
////
////
//// void push(int x) 将元素 x 推到队列的末尾
//// int pop() 从队列的开头移除并返回元素
//// int peek() 返回队列开头的元素
//// boolean empty() 如果队列为空，返回 true ；否则，返回 false
////
////
////
////
//// 说明：
////
////
//// 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
////
//// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
////
////
////
////
//// 进阶：
////
////
//// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
////
////
////
////
//// 示例：
////
////
////输入：
////["MyQueue", "push", "push", "peek", "pop", "empty"]
////[[], [1], [2], [], [], []]
////输出：
////[null, null, null, 1, 1, false]
////
////解释：
////MyQueue myQueue = new MyQueue();
////myQueue.push(1); // queue is: [1]
////myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
////myQueue.peek(); // return 1
////myQueue.pop(); // return 1, queue is [2]
////myQueue.empty(); // return false
////
////
////
////
////
////
////
//// 提示：
////
////
//// 1 <= x <= 9
//// 最多调用 100 次 push、pop、peek 和 empty
//// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
////
//// Related Topics 栈 设计
//// 👍 269 👎 0
//
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class MyQueue {
//    private Deque<Integer> pushStack;
//    private Deque<Integer> popStack;
//
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//        pushStack = new ArrayDeque<>();
//        popStack = new ArrayDeque<>();
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        //在任何时候都可以向pushStack堆入元素
//        pushStack.addLast(x);
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        //从popStack取出元素
//        if (!popStack.isEmpty()){
//            return popStack.removeLast();
//        }
//        //走到这里是因为popStack为空，此时需要将pushStack里的所有元素依次放入popStack
//        while (!pushStack.isEmpty()){
//            pushStack.addLast(pushStack.removeLast());
//        }
//        return popStack.removeLast();
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        // 从 popStack 取出元素
//        if (!popStack.isEmpty()) {
//            return popStack.peekLast();
//        }
//        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
//        while (!pushStack.isEmpty()) {
//            popStack.addLast(pushStack.removeLast());
//        }
//        return popStack.peekLast();
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        // 两个栈都为空，才说明队列为空
//        return pushStack.isEmpty() && popStack.isEmpty();
//    }
//}
//
///**
// * Your MyQueue object will be instantiated and called as such:
// * MyQueue obj = new MyQueue();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.peek();
// * boolean param_4 = obj.empty();
// */
////leetcode submit region end(Prohibit modification and deletion)
