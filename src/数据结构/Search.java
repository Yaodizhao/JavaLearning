package 数据结构;

/**
 * @author 如月车站
 */
public class Search {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 8, 9, 31, 52, 61, 71, 102};
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Search search = new Search();
        int result = search.binarySearch(array, 71);
        System.out.println(result);
    }

    public int lineSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return target;
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
        return target;
    }

}
