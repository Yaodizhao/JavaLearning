package LeetCode;

import java.sql.Array;
import java.util.Arrays;

public class s1672 {
    public static int maximumWealth_Improvement(int[][] accounts) {
        int max = 0;
        for (int[] account: accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }
    
    
    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;
        int max = 0, sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            max = max > sum ? max : sum;
            sum = 0;
        }
        return max;
    }
}
