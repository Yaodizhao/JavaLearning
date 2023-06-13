package LeetCode.困难;

/**
 * @author 如月车站
 */
public class s1330翻转子数组获得最大数组值 {
    public int maxValueAfterReverse(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(nums[i] - nums[i + 1]);
        }
        int mx1 = 0;

        for (int i = 1; i < n - 1; i++) {
            // 包含nums[0]
            mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            // 包含nums[n-1]
            mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            mx2 = Math.max(mx2, Math.min(x, y));
            mn2 = Math.min(mn2, Math.max(x, y));
        }
        return ans + Math.max(mx1, 2 * (mx2 - mn2));
    }
}
