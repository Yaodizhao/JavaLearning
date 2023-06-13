package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s17电话组合 {


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, "", res, phoneMap);
        return res;
    }

    private void dfs(String digits, String s, List<String> res, Map<Character, String> phoneMap) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        for (char c : phoneMap.get(digits.charAt(s.length())).toCharArray()) {
            dfs(digits, s + c, res, phoneMap);
        }

    }
}
