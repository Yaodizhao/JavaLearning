package LeetCode;

import java.util.Arrays;

public class LeetCodeMain {
    public static void main(String[] args) {
        int n = 2;
        int[] array = new int[]{2, 2, 2, 3, 3};
        Arrays.sort(array);
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 3) {
                flag = i - 1;
                break;
            }
        }
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            int t = (array.length - 2 * i + 2) * (i + 1);
            if (t > 0) {
                sum += t;
            }
            for (int j = 1; j < i; j++) {
                sum += (j + 1) * (i - j + 1);
            }
        }
        sum += (flag + 2) * (array.length - flag);
        System.out.println(sum);

//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 30,
//                TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), new DaemonThreadFactory("test"));
//
//        System.out.println(pool);
//        CompletableFuture<Integer> completableFuture =new CompletableFuture<>();
        /*
        运用流处理数组字符串
        int[] e = new int[]{1, 2, 6, 12, 5, 99};
        System.out.println(Arrays.stream(e).max().getAsInt());
        String[] words = new String[]{"hello", "world"};
        List<String> ew = Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().toList();
        ew.forEach(System.out::print);
        */
    }

    public static int getFactor(int n1, int n2) {
        return (n1 + 1) * (n2 + 1);
    }
}




