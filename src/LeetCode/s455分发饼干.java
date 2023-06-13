package LeetCode;

import java.util.Arrays;

public class s455分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        if (index==-1){
            return 0;
        }
        for (int i = g.length - 1; i >= 0; i--) {
            if (s[index] >= g[i]) {
                result++;
                index--;
                if (index < 0) {
                    break;
                }
            }
        }
        return result;
    }
}
