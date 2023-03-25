package LeetCode;

public class s1413 {
    public static int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = min > sum ? sum : min;
        }
        return 1 - min;
    }
}
