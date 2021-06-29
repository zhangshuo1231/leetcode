package com.company;

import java.util.Collections;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return Collections.min(stack);
    }
}
