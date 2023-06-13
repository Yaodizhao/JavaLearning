package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class s131分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    Boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        partition(s, 0, s.length());
        return res;
    }

    private void partition(String s, int i, int length) {
        if (i == length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < length; j++) {
            if (isPalindrome(s.substring(i, j + 1))) {
                temp.add(s.substring(i, j + 1));
                partition(s, j + 1, length);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
