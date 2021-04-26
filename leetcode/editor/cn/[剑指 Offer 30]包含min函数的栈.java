//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 83 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> A,B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    
    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();
    }


     /*

    private static Stack<Integer> stack = new Stack<>();
    private static Integer minElement = Integer.MAX_VALUE;
    public void push(int node) {
        if (stack.empty()){
            minElement = node;
            stack.push(node);
        }else {
            if (node <= minElement){
                stack.push(minElement);//在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        //增加最后一个元素以及栈为空时候的检测
        if (stack.size() == 0)
            return;
        if (minElement == stack.peek()){  //如果栈顶是最小值，如果将栈顶元素弹出，则最小值改变
            if (stack.size() > 1){  //判断栈中元素是否有两个或两个以上
                stack.pop();  //弹出栈顶元素
                minElement = stack.peek();  //弹出栈中元素，并修改最小值为弹出栈顶元素后的元素
            }else {
                minElement = Integer.MAX_VALUE; //如果栈中只有一个元素，则修改最小值为无穷大后再弹出
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }

      */


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
