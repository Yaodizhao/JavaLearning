package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s39组合总和 {
    public static void main(String[] args) {
        List<List<Integer>> listList = new s39组合总和().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(listList);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, 0, candidates.length, target);
        return res;
    }

    private void combinationSum(int[] candidates, int start, int len, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < len; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            combinationSum(candidates, i + 1, len, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
