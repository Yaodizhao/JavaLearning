package LeetCode;

public class s459重复的子字符串 {
    public static void main(String[] args) {
        boolean i = new s459重复的子字符串().repeatedSubstringPattern("abac");
        System.out.println(i);
    }

    public boolean repeatedSubstringPattern(String s) {
//        String ss = s.concat(s).substring(1, 2 * s.length() - 1);
//        return strStr(ss, s) >= 0;
        int[] next = getNext(s);
        return next[s.length()] != 0 && s.length() % (s.length() - next[s.length()]) == 0;
    }

    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystackArray.length && j < needleArray.length) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == needleArray.length) {
            return i - needle.length();
        }
        return -1;
    }

    public int[] getNext(String subStr) {
        char[] array = subStr.toCharArray();
        int[] next = new int[subStr.length() + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < subStr.length()) {
            if (j == -1 || array[j] == array[i]) {
                i++;
                j++;
                next[i] = j;
            } else {
                while (j != -1 && array[j] != array[i]) {
                    j = next[j];
                }
            }
        }
        return next;
    }
}
