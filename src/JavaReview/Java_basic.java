package JavaReview;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java_basic {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer("aa");
        System.out.println(stringBuffer);
        
        byte[] bytes = new byte[]{'a', 'b', 'c'};
        String s = new String(bytes);
        System.out.println(s);
        
        // ArrayList<String>[] list15 = (ArrayList<String>[])new ArrayList<?>[10];
        ArrayList<String>[] list15 = new ArrayList[10];
        list15[0] = new ArrayList<>();
        list15[0].add("1213");
        list15[0].add("12132");
        System.out.println(list15[0]);
        
        String throwable = new Throwable("aa").toString();
        System.out.println(throwable);
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        Stack<Integer> dq = new Stack<>();
        dq.add(1);
        System.out.println(dq.capacity() + "   " + Arrays.toString(arrayDeque.toArray()));
        
        //包装成同步的
        Map<Integer, Integer> m = Collections.synchronizedMap(new LinkedHashMap<>());
        Map<Integer, Integer> m1 = new WeakHashMap<>();
        
        
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
    
    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }
}

class ThreadUnsafeExample {
    
    private int cnt = 0;
    
    public void add() {
        cnt++;
    }
    
    public int get() {
        return cnt;
    }
}

