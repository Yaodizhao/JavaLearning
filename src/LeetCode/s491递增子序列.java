package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s491递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequences(nums, 0);
        return res;
    }

    public void findSubsequences(int[] nums, int start) {
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        /*要判断是否用过了*/
        Map<Integer, Integer> used = new HashMap<>(15);
        for (int i = start; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.get(temp.size() - 1)) {
                continue;
            }
            if (used.containsKey(nums[i])) {
                continue;
            }
            used.put(nums[i], 1);
            temp.add(nums[i]);
            findSubsequences(nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
