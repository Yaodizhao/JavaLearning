package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class s349两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new s349两个数组的交集().intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                if (map.get(j) == 1) {
                    result.add(j);
                    map.replace(j, -1);
                }
            }

        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
