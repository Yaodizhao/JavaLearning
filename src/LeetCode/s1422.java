package LeetCode;

public class s1422 {
    public static int maxScore(String s) {
        int max0 = 0, max1 = 0;
        for (int i = 1; i < s.length(); i++) {
            max1 += s.charAt(i) - '0';
        }
        if (s.charAt(0) == '0')
            max0 = 1;
        else
            max0 = 0;
        int max = max0 + max1;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                max0++;
            } else {
                max1--;
            }
            max = Math.max(max, max0 + max1);
        }
        return max;
    }
}
