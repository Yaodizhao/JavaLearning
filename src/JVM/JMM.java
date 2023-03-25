package JVM;

public class JMM {
    static volatile boolean run = true;
    //改成volatile 即可每次都从主存获取 可以保证可见性 但是不能保证原子性 但是synchronized可以保证
    
    
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {
            //  循环无法退出 因为一直获取run所以把run放入高速缓存中了
            }
        });
        t.start();
        
        Thread.sleep(1000);
        run = false;
    }
}
