package LeetCode;

import java.util.HashMap;

public class s454四数相加 {
    public static void main(String[] args) {
        int[] int1 = {1, 2};
        int[] int2 = {-2, -1};
        int[] int3 = {-1, 2};
        int[] int4 = {0, 2};
        System.out.println(new s454四数相加().fourSumCount(int1, int2, int3, int4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int value : nums1) {
            for (int value2 : nums2) {
                int sum = value + value2;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }

            }
        }

        for (int value : nums3) {
            for (int value2 : nums4) {
                if (map.containsKey(-1 * value - value2)) {
                    result += map.get(-1 * value - value2);
                }
            }
        }
        return result;
    }
}
