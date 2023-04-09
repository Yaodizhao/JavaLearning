package LeetCode.困难;

import java.util.LinkedList;

public class s768辅助栈 {
    //前后缀匹配
    public static int maxChunksToSorted(int[] arr) {
        int sum = 1;
        int[] suffixminarray = new int[arr.length];
        int[] prefixmaxarray = new int[arr.length];
        prefixmaxarray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixmaxarray[i] = Math.max(prefixmaxarray[i - 1], arr[i]);
        }
        suffixminarray[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixminarray[i] = Math.min(suffixminarray[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (prefixmaxarray[i] <= suffixminarray[i + 1])
                sum++;
        }
        
        return sum;
    }
    
    //辅助栈
    public static int maxChunksToSorted_inprovement(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int num: arr) {
            if (! stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while (! stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                stack.addLast(head);
            } else stack.addLast(num);
        }
        return stack.size();
    }
    
}
