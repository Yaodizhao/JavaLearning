package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 如月车站
 */
public class s77组合 {
    public static void main(String[] args) {
        List<List<Integer>> combine = new s77组合().combinationSum3(3, 7);
        System.out.println(combine);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, 1, k);
        return res;
    }

    public void combine(int n, int start, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combine(n, i + 1, k);
            temp.remove(temp.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, 1, n, 0);
        return res;
    }

    private void combinationSum3(int k, int start, int n, int sum) {
        if (temp.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            combinationSum3(k, i + 1, n, sum + i);
            temp.remove(temp.size() - 1);
        }
    }
}
