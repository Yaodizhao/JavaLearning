package LeetCode;

public class s1417 {
    public static String reformat(String s) {
        String[] letter = s.split("[0-9]");
        StringBuilder sb1 = new StringBuilder();
        for (String s1: letter) {
            sb1.append(s1);
        }
        String[] num = s.split("[a-z]");
        StringBuilder sb2 = new StringBuilder();
        for (String s1: num) {
            sb2.append(s1);
        }
        StringBuilder result = new StringBuilder();
        if (Math.abs(sb1.length() - sb2.length()) > 1)
            return "";
        else {
            
            int i = sb1.length(), j = sb2.length();
            if (i > j) {
                for (int k = 0; k < i - 1; k++) {
                    result.append(sb1.charAt(k));
                    result.append(sb2.charAt(k));
                }
                result.append(sb1.charAt(i - 1));
            } else if (i < j) {
                for (int k = 0; k < j - 1; k++) {
                    result.append(sb2.charAt(k));
                    result.append(sb1.charAt(k));
                }
                result.append(sb2.charAt(j - 1));
            } else {
                for (int k = 0; k < j; k++) {
                    result.append(sb2.charAt(k));
                    result.append(sb1.charAt(k));
                }
            }
            
            
        }
        return result.toString();
    }
    
    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    
    public static String reformat_Improvement(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        
        boolean flag = sumDigit > sumAlpha;
        // 那么我们用 i 和 j 来分别表示个数多的和个数少的字符放置的下标，初始为 i = 0, j = 1 然后从左到右移动 i，当 s[i] 为个数少的字符类型时，那么向右移动 j 找到往后的第一个s[j] 为个数多的字符类型，然后交换两个字符即可，不断重复该过程直至 i 移动到字符串结尾即可。
        char[] arr = s.toCharArray();
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }
    
}
