package LeetCode.剑指Offer;

public class s58左旋字符串 {
    public static void main(String[] args) {
        String s = new s58左旋字符串().reverseLeftWords("abcdefg", 2);
        System.out.println(s);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
