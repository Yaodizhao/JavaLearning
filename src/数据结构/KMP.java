package 数据结构;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBCABCDABABCDABCDABDE";
        String str2 = "ABCDABD";
        KMP(str1, str2);
    }
    
    public static void KMP(String str1, String str2) {
        int i = 0, j = 0;
        int[] next = getNextArray(str2);
        while (i < str1.length() && j < str2.length()) {
            if (j == - 1 || str1.charAt(i) == str2.charAt(j)) {
                ++ i;
                ++ j;
            } else {
                j = next[j];
            }
        }
        if (j >= str2.length()) {
            System.out.println("111");
        } else {
            System.out.println("222");
        }
    }
    
    public static int[] getNextArray(String str) {
        int[] next = new int[str.length()];
        int i = 0, j = - 1;
        next[0] = - 1;
        while (i < str.length() - 1) {
            if (j == - 1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
