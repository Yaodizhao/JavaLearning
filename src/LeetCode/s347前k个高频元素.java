package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class s347前k个高频元素 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new s347前k个高频元素().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // pair2[1] - pair1[1]表示降序排列，相当于大顶堆，
        // 即出现次数按从多到少排，也就是从队头到队尾的顺序,出现次数最多的在队头，方便出队
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        map.forEach((key, value) -> {
            pq.offer(new int[]{key, value});
        });
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
