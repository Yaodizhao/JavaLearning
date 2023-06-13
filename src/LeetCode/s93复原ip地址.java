package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class s93复原ip地址 {
    public static void main(String[] args) {
        System.out.println(new s93复原ip地址().restoreIpAddresses("25525511135"));
    }

    List<String> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return res;
        }
        restoreIpAddresses(s, 0, 0);
        return res;
    }

    public void restoreIpAddresses(String s, int ipNum, int start) {
        if (start == s.length()) {
            if (ipNum == 4) {
                res.add(temp.get(0) + '.' + temp.get(1) + '.' + temp.get(2) + '.' + temp.get(3));
            } else {
                return;
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (isIp(s.substring(start, i + 1))) {
                temp.add(s.substring(start, i + 1));
                restoreIpAddresses(s, ipNum + 1, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    Boolean isIp(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.startsWith("0"))) {
            return false;
        }
        return Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
    }
}
