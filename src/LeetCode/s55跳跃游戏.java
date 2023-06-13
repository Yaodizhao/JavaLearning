package LeetCode;

public class s55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int step = 0;
        for (int i = 0; i <= step; i++) {
            step = Math.max(step, i + nums[i]);
            if (step >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int jump = new s55跳跃游戏().jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5});
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        int step = 0;
        int result = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            step = Math.max(step, i + nums[i]);
            if (i == end) {
                end = step;
                result++;
            }
        }
        return result;
    }


}
