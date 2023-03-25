package JavaCoreLearning1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.IntFunction;

public class Chap8 {
    public static void main(String[] args) {
        ArrayList files = new ArrayList();
        
        files.add(new File("src\\b.txt"));
        files.add(1);
        for (Object file: files) {
            System.out.println(file.toString());
            System.out.println(file.getClass());
        }
        String filename = files.get(0).toString();
        System.out.println(filename);
//        需要强制转换
        String x1 = String.valueOf(files.get(0));
        
        ArrayList<String> filelist = new ArrayList<>();
        filelist.add((new File("src\\b.txt")).toString());
        filelist.add(String.valueOf(1));
//        不需要强制转换
        String x = filelist.get(0);
        
        Pair<Integer> pair = new Pair<>(1, 2);
        System.out.println("first是：" + pair.getFirst());
        
        String[] source = new String[]{"mary", "had", "a", "lamb", "apple"};
        Pair<String> mm = ArrayAlg.minmax(source);
        System.out.println(mm.getFirst() + "-" + mm.getSecond());
        System.out.println(ArrayAlg.getMiddle(source));
        double middle = ArrayAlg.getMiddle(3.14, 1729.0, 0.0);
        
        
        Pair<String>[] p = new Pair[10];
        
        Collection<Pair<String>> table = new ArrayList<>();
        Pair<String> pair1 = new Pair<>("xa", "xb");
        Pair<String> pair2 = new Pair<>();
        ArrayAlg.addALL(table, pair1, pair2);
        for (Pair<String> stringPair: table) {
            System.out.println(stringPair.getFirst());
        }

//      使用IntFunction接口通过lambda来创建泛型数组
//      String[]::new
        String[] ss = ArrayAlg.minmax(String[]::new, "Tom", "Dick", "Harry");
        for (String s: ss) {
            System.out.println("ss:" + s);
        }
    }
    
}

class Pair<T> {
    private T first;
    private T second;
    
    public Pair() {
        first = null;
        second = null;
    }
    
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public T getSecond() {
        return second;
    }
    
    public void setFirst(T newValue) {
        first = newValue;
    }
    
    public void setSecond(T newValue) {
        second = newValue;
    }
}

class ArrayAlg {
    
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
    
    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
        // 错误无法类型转换
        // Object[] mm = new Object[2];
        // return (T[])mm;
        T[] mm = constr.apply(2);
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        mm[0] = min;
        mm[1] = max;
        return mm;
    }
    
    public static <T extends Comparable> T getMiddle(T... a) {
        return a[a.length / 2];
    }
    
    //    擦除
    // public static Comparable getMiddle(Comparable... a) {
    //     return a[a.length / 2];
    // }
    // 如果当两个类的擦除与多态产生冲突 可添加一个桥方法
    public static <T extends Comparable> T min(T[] a) // almost correct
    {
        if (a == null || a.length == 0)
            return null;
        
        T smallest = a[0];
        
        for (int i = 1; i < a.length; i++) {
//            为了保证smallest具有compareTo方法 使用extends
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }
        return smallest;
    }
    
    @SafeVarargs
    public static <T> void addALL(Collection<T> coll, T... ts) {
//        for (T t: ts) coll.add(t);
//        等于下面的
        Collections.addAll(coll, ts);
    }
}
