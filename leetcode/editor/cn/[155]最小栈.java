//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 699 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    /**
     * 初始化栈
     */
    private Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    /**
     * 栈元素中同时存储当前元素值和最小值
     * @param x
     */
    public void push(int x) {
        //
        if (stack.isEmpty()){
            stack.push(new Node(x,x));
        }else {
            stack.push(new Node(x,Math.min(x,stack.peek().min)));
        }
    }

    /**
     * 直接删除栈顶元素
     */
    public void pop() {
        stack.pop();

    }

    /**
     * 直接返回栈顶元素的元素值即可
     * @return
     */
    public int top() {
        return stack.peek().val;
    }

    /**
     * 返回栈顶元素存储的最小值
     * @return
     */
    
    public int getMin() {

        return stack.peek().min;
    }

    /**
     * 定义Node，保存数据和当前的最小值
     */
    private static class Node{
        int val;
        int min;

        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
