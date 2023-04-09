package LeetCode;

import java.util.ArrayDeque;

public class s225用队列实现栈 {

    class MyStack {

        ArrayDeque<Integer> queue1;
        //        ArrayDeque<Integer> queue2;
        int size;

        public MyStack() {
            queue1 = new ArrayDeque<>();
//            queue2 = new ArrayDeque<>();
            size = 0;
        }

        public void push(int x) {
            size++;
            queue1.push(x);
        }

        public int pop() {
            size--;
            int x = queue1.peek();
            queue1.pop();
            return x;
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return size == 0;
        }
    }
}
