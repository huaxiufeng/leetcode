package algorithm.java;

import java.util.Stack;

/**
 * Created by huaxiufeng on 19/3/11.
 */
public class LC232ImplementQueueUsingStacks {

    static class MyQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;

        /** Initialize your data structure here. */
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.empty() && out.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.peek());   // returns 2
        System.out.println(queue.empty()); // returns false
    }
}
