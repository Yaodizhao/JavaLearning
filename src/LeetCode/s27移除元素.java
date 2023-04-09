package LeetCode;

public class s27移除元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        System.out.println(removeElement(nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]!= val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
