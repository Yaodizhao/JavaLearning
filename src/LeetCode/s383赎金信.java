package LeetCode;

public class s383赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] Hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            Hash[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (-- Hash[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
