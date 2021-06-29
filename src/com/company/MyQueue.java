package com.company;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) stack.push(x);
        else {
            Stack<Integer> tmp = new Stack<>();
            while (!stack.isEmpty()) tmp.push(stack.pop());
            tmp.push(x);
            while (!tmp.isEmpty()) stack.push(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns tha element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

}
