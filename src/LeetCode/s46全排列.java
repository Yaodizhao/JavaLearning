package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s46全排列 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new s46全排列().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] index;

    public List<List<Integer>> permute(int[] nums) {
        index = new int[nums.length];
        permute(nums, 0, 0);
        return res;
    }

    private void permute(int[] nums, int i, int k) {
        if (k == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (index[j] != 0) {
                continue;
            }
            index[j] = 1;
            temp.add(nums[j]);
            permute(nums, j + 1, k + 1);
            index[j] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        index = new int[nums.length];
        permuteUnique(nums, 0, 0);
        return res;
    }

    private void permuteUnique(int[] nums, int i, int k) {
        if (k == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (index[j] != 0) {
                continue;
            }
            // 排序过后取出前后一样的
            if (j > 0 && index[j - 1] == 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            index[j] = 1;
            temp.add(nums[j]);
            permuteUnique(nums, j + 1, k + 1);
            index[j] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
