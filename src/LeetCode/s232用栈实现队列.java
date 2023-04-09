package LeetCode;

import java.util.Stack;

public class s232用栈实现队列 {
    public static void main(String[] args) {

    }

    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            size = 0;
        }

        public void push(int x) {
            stack1.push(x);
            size++;
        }

        public int pop() {
            size--;
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }

        public int peek() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            } else {
                return stack1.get(0);
            }
        }

        public boolean empty() {
            return size == 0;
        }
    }
}
