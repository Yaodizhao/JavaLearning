package LeetCode;

public class s1413逐步求和得到正数最小值 {
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
