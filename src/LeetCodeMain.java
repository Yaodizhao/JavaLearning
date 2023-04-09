import static LeetCode.困难.s1687从仓库到码头运输箱子.boxDelivering;

public class LeetCodeMain {
    public static void main(String[] args) {
        int[][] boxes = new int[][]{{2, 4}, {2, 5}, {3, 1}, {3, 2}, {3, 7}, {3, 1}, {4, 4}, {1, 3}, {5, 2}};
        int portsCount = 5;
        int maxBoxes = 5;
        int maxWeight = 7;
        int i = boxDelivering(boxes, portsCount, maxBoxes, maxWeight);
        System.out.println(i);
        /*
        运用流处理数组字符串
        int[] e = new int[]{1, 2, 6, 12, 5, 99};
        System.out.println(Arrays.stream(e).max().getAsInt());
        String[] words = new String[]{"hello", "world"};
        List<String> ew = Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().toList();
        ew.forEach(System.out::print);
        */
    }
}




