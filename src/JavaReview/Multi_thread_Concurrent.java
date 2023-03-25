package JavaReview;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Multi_thread_Concurrent {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CachedThreadPool: 一个任务创建一个线程
        // FixedThreadPool: 所有任务只能使用固定大小的线程
        // SingleThreadExecutor: 相当于大小为 1 的 FixedThreadPool
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
            // 线程休眠
            Thread.sleep(100);
        }
        executorService.shutdown();
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
        
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.incrementAndGet());
    }
    
    public static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("ydz");
            // 对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。
            // 该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。
            Thread.yield();
        }
    }
    
    public static class MyCallable implements Callable<Integer> {
        public Integer call() {
            return 123;
        }
    }
    
    public static class MyThread extends Multi_thread_Concurrent {
        public void run() {
            System.out.println("yyddzz");
        }
    }
}
