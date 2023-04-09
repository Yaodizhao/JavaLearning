package LeetCode;

public class s541翻转字符串2 {
    public static void main(String[] args) {
        String s = new s541翻转字符串2().reverseStr("abcd", 4);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public String reverseStr(String s, int k) {
//        char[] ch = s.toCharArray();
        if (s.length() < k) {
            return new StringBuilder(s).reverse().toString();
        }
        if (s.length() < 2 * k) {
            return new StringBuilder(s.substring(0, k)).reverse().toString().concat(s.substring(k));
        }
        int i;
        for (i = 0; s.length() - i - 2 * k >= 0; i += 2 * k) {
            s = s.substring(0, i) + new StringBuilder(s.substring(i, i + k)).reverse() + s.substring(i + k);
        }
        int left = s.length() - i;
        int right = s.length() - left;
        if (left < k) {
            return s.substring(0, right).concat(new StringBuilder(s.substring(right)).reverse().toString());
        }
        if (left < 2 * k) {
            return s.substring(0, right).concat(new StringBuilder(s.substring(right, right + k)).reverse().toString()).concat(s.substring(right + k));
        }
        return s;
    }
}
