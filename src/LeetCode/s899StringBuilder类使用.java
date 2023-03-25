package LeetCode;

import java.util.Arrays;

public class s899StringBuilder类使用 {
    public static String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                //  stringbuilder 删除字节 添加字节
                sb.deleteCharAt(0);
                sb.append(c);
                if (smallest.compareTo(new String(sb)) > 0) {
                    smallest = new String(sb);
                }
            }
            return smallest;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
