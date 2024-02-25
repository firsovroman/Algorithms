package Data_structures.queue_and_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackImp {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.empty());
    }

    static class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int top;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.add(x);
            top = x;
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int element = queue1.poll();
            if (!queue1.isEmpty()) {
                top = queue1.peek();
            }
            return element;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
