package club.csiqu.practice.past;

import java.util.Stack;

/**
 * 最小栈问题
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    private void push(int node) {
        stack.push(node);
        if (min.empty()) {
            min.push(node);
        } else if (node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    private void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    private int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(0);
        System.out.println(minStack.min());
    }
}