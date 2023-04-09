package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class s151反转字符串中的单词 {
    public static void main(String[] args) {
        String s = new s151反转字符串中的单词().reverseWords("a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        List<String> dic = new ArrayList<String>();
        char[] chars = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                if (sb.length() > 0) {
                    dic.add(sb.toString().trim());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(aChar);
            }
        }
        dic.add(sb.toString().trim());
        int left = 0, right = dic.size() - 1;
        while (left < right) {
            String temp = dic.get(left);
            dic.set(left, dic.get(right));
            dic.set(right, temp);
            left++;
            right--;
        }
        dic.forEach(item -> result.append(item).append(" "));
        return result.substring(0, result.length() - 1);
    }
}
