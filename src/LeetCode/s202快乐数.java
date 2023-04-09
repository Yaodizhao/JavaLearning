package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class s202快乐数 {
    public static void main(String[] args) {
        System.out.println(new s202快乐数().isHappy(19));
    }

    private boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public int getNextNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
