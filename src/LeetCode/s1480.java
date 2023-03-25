package LeetCode;

public class s1480 {
    public static int[] runningSum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + sum;
            sum = nums[i];
        }
        return nums;
    }
    
    public static int[] runningSum_correction(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
