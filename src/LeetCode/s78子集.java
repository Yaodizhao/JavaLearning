package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s78子集 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(nums, 0);
        return res;
    }

    public void subsetsWithDup(int[] nums, int start) {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1);
            temp.remove(temp.size() - 1);

        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return res;
    }

    public void subsets(int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[start]);
        subsets(nums, start + 1);
        temp.remove(temp.size() - 1);
        subsets(nums, start + 1);
    }
}
