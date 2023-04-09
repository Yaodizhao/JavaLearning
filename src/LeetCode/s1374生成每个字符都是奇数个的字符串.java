package LeetCode;

import java.util.Arrays;

public class s1374生成每个字符都是奇数个的字符串 {
    public static String generateTheString_Improvement(int n) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        if (n % 2 == 0) ans[n - 1] = 'b';
        return String.valueOf(ans);
    }
    
    public static String generateTheString(int n) {
        //  生成重复的字符串
        String str = ("a").repeat(n - 1);
        return n % 2 == 1 ? str + 'a' : str + 'b';
    }
}
