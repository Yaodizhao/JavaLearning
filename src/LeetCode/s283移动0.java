package LeetCode;

import java.util.Arrays;

public class s283移动0 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                zeroes++;
            } else {
                nums[i - zeroes] = nums[i];
            }
        }
        for (int i = 0; i < zeroes; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }
}
