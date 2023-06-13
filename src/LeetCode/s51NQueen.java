package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s51NQueen {
    public static void main(String[] args) {
        List<List<String>> lists = new s51NQueen().solveNQueens(4);
        System.out.println(lists);
    }

    List<List<String>> result = new ArrayList<List<String>>();
    List<Integer> temp = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        nQueens(n, 0);
        return result;
    }

    public void nQueens(int n, int step) {
        if (step == n) {
            List<String> positions = new ArrayList<>(n);
            char[] c = new char[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(c, '.');
                c[temp.get(j)] = 'Q';
                positions.add(String.valueOf(c));
            }
            result.add(new ArrayList<String>(positions));
            return;
        }
        for (int i = 0; i < n; i++) {
            temp.add(i);
            if (judge(step)) {
                nQueens(n, step + 1);
            }
            temp.remove(temp.size() - 1);
        }
    }

    public boolean judge(int count) {
        for (int i = 0; i < count; i++) {
            if (temp.get(i).equals(temp.get(count)) || Math.abs(count - i) == Math.abs(temp.get(count) - temp.get(i))) {
                return false;
            }
        }
        return true;
    }
}
