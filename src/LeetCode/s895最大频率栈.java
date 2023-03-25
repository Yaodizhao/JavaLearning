package LeetCode;

import java.util.*;

public class s895最大频率栈 {
    public static class FreqStack {
        
        private final Map<Integer, Integer> cnt;
        private final List<Stack<Integer>> frec;
        
        public FreqStack() {
            cnt = new HashMap<>();
            frec = new ArrayList<>();
        }
        
        public void push(int val) {
            // 获取此时最大频率
            int c = frec.size();
            cnt.merge(val, 1, Integer::sum);
            if (cnt.get(val) > c) {
                frec.add(new Stack<>());
                frec.get(c).push(val);
            } else {
                frec.get(cnt.get(val) - 1).push(val);
            }
        }
        
        public int pop() {
            int top = frec.size() - 1;
            int val = frec.get(top).pop();
            if (frec.get(top).isEmpty()) {
                frec.remove(top);
            }
            cnt.merge(val, - 1, Integer::sum);
            System.out.println(val);
            return val;
        }
    }
}
