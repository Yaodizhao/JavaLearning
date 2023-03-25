package JVM;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class ClassTest {
    public static void main(String[] args) {
        
        String s = new String("a") + new String("b");
        // s.intern();
        // 先入池导致true
        String x = "ab";
        s.intern();
        // 后入池 x已经将ab入池 所以intern函数不能入常量池 只能在堆中 导致false
        System.out.println(s == x);
        
        // 调整堆大小 -Xmx20m -XX:+PrintGCDetails -verbose:gc
        // 堆会溢出
        // List<byte[]> list1 = new ArrayList<>();
        // for (int i = 0; i < 5; i++) {
        //     byte[] ref = new byte[4 * 1024 * 1024];
        //     list1.add(ref);
        //     System.out.println(list1.size());
        // }
        
        //不会溢出
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[4 * 1024 * 1024]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        
        for (SoftReference<byte[]> softReference: list) {
            System.out.println(softReference.get());
        }
    }
}
