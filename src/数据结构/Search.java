package 数据结构;

import java.util.Arrays;

/**
 * @author 如月车站
 */
public class Search {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 8, 9, 31, 52, 61, 71, 102};
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Search search = new Search();
        int result = search.fibonacciSearch(array, 52);
        System.out.println(result);
    }

    public int lineSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 插值查找
     *
     * @param nums   数组
     * @param target 查找值
     * @return 查找结果
     */
    public int interpolationSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) * (target - nums[low]) / (nums[high] - nums[low]);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int fibonacciSearch(int[] nums, int target) {

        int[] fibonacci = fibonacci();
        int low = 0;
        int high = nums.length - 1;
        int k = 0;
        int mid = 0;
        while (fibonacci[k] - 1 < high) {
            k++;
        }
        int[] temp = Arrays.copyOf(nums, fibonacci[k]);
        Arrays.fill(temp, high, temp.length, nums[high]);
        while (low < high) {
            mid = low + fibonacci[k - 1] - 1;
            if (temp[mid] == target) {
                return mid;
            } else if (temp[mid] > target) {
                low = mid + 1;
                k -= 2;
            } else {
                high = mid - 1;
                k--;
            }
        }
        return -1;
    }

    public int[] fibonacci() {
        int[] nums = new int[20];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums;
    }

}
