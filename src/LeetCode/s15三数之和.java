package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class s15三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listList = threeSum(nums);
        listList.forEach(i -> {
            for (Integer integer : i) {
                System.out.print(integer.toString());
                System.out.print(" ");
            }
            System.out.print("\n");
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        HashMap<List<Integer>, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || nums[nums.length - 2] < 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!map.containsKey(list)) {
                        listList.add(list);
                        map.put(list, true);
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return listList;
    }
}
