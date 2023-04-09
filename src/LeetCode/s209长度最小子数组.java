package LeetCode;

public class s209长度最小子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen_modify(7, nums));
    }

    // 可以只滑动前的窗口
    public static int minSubArrayLen_modify(int target, int[] nums) {
        int front = 0, rear = 0;
        int sum = target, min = Integer.MAX_VALUE;
        while (rear < nums.length) {
            sum -= nums[rear];
            while (sum <= 0) {
                min = Math.min(min, rear - front + 1);
                sum = sum + nums[front++];
            }
            rear++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 长度大于target的长度最小连续子数组
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int front = 0, rear = 0, length = 0;
        int flag = 0;
        int sum = target, min = Integer.MAX_VALUE;
        while (front < nums.length) {
            sum -= nums[rear];
            if (sum <= 0) {
                if (min > length) {
                    min = length + 1;
                    flag = 1;
                }
                length = 0;
                sum = target;
                front++;
                rear = front;
            } else {
                length++;
                if (rear == nums.length - 1) {
                    break;
                }
                rear++;
            }
        }
        if (flag == 0) {
            return 0;
        }
        return min;
    }

    /**
     * 长度等于target的长度最小连续子数组
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minEquelArrayLen(int target, int[] nums) {
        int front = 0, rear = 0, length = 0;
        int flag = 0;
        int sum = target, min = Integer.MAX_VALUE;
        while (front < nums.length) {
            sum -= nums[rear];
            if (sum < 0) {
                length = 0;
                sum = target;
                front++;
                rear = front;
            } else if (sum == 0) {
                if (min > length) {
                    min = length + 1;
                    flag = 1;
                }
                length = 0;
                sum = target;
                front++;
                rear = front;
            } else {
                length++;
                if (rear == nums.length - 1) {
                    break;
                }
                rear++;
            }
        }
        if (flag == 0) {
            return 0;
        }
        return min;
    }
}
