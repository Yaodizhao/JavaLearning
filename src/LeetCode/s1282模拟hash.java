package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s1282模拟hash {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> temp = new ArrayList<>(groupSizes.length);
        for (int i = 0; i <= groupSizes.length; i++) {
            temp.add(new ArrayList<>());
        }
        for (int i = 0; i < groupSizes.length; i++) {
            temp.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            if (! temp.get(i).isEmpty()) {
                int length = temp.get(i).size();
                while (length != 0) {
                    result.add(new ArrayList<>());
                    for (int j = 0; j < i; j++) {
                        result.get(result.size() - 1).add(temp.get(i).get(length - j - 1));
                    }
                    length -= i;
                }
            }
        }
        return result;
    }
    
    //满仓转移，虚位以待
    public static List<List<Integer>> groupThePeople_improvement(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int cur = groupSizes[i];
            //putIfAbsent() 方法会先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中。
            map.putIfAbsent(cur, new ArrayList<Integer>());
            map.get(cur).add(i);
            if (map.get(cur).size() == cur) {
                ans.add(map.get(cur));
                map.remove(cur);
            }
        }
        return ans;
    }
}
