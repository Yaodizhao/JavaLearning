package LeetCode;

public class s28KMP {
    public static void main(String[] args) {
        int i = new s28KMP().strStr("hello", "ll");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
//        char[] haystackArray = haystack.toCharArray();
//        char[] needleArray = needle.toCharArray();
//        int[] next = getNext(needle);
//        for (int i = 0, j = 0; i < haystack.length(); i++) {
//            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//                j = next[j];
//            }
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            if (j == needle.length()) {
//                return i - needle.length() + 1;
//            }
//        }
//        return -1;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int[] next = new s28KMP().getNext(needle);
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
