package JavaCoreLearning1;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Integer.parseInt;

public class review {
    public static void main(String[] args) throws ParseException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        对象api();
    }
    
    public static void 字符串函数api() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "aacdefghijklmnopqrstuvwxyz";
        System.out.println(s.charAt(1));
        //ASCII码值
        System.out.println(s.codePointAt(1));
        System.out.println(s.offsetByCodePoints(1, 5));
        int[] code = {97, 98, 101, 111};
        System.out.println(new String(code, 0, 4));
        System.out.println(s.compareTo(s2));
        System.out.println(s.isBlank());
        System.out.println(s.startsWith("a"));
        System.out.println(s.indexOf("uv"));
        //反向匹配
        System.out.println(s.lastIndexOf("uv"));
        System.out.println(s.substring(1, 6).getClass());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.repeat(3));
        
        StringBuilder sb = new StringBuilder("ab");
        sb.append(true);
        sb.appendCodePoint(97);
        sb.deleteCharAt(1);
        sb.insert(2, "ab");
        System.out.println(sb);
    }
    
    public static void 读取文件api() throws IOException {
        PrintWriter out = new PrintWriter("src/JavaCoreLearning/a.txt", StandardCharsets.UTF_8);
        out.write("aa");
        out.append("bb");
        out.close();
    }
    
    public static void 数组api() {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 3, 33, 3, 3, 3};
        System.out.println(Math.random());
        String s = Arrays.toString(array);
        System.out.println(s);
        System.out.println(s.charAt(0));
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 2, 6)));
        
        Arrays.sort(array);
        System.out.println(Arrays.binarySearch(array, 33));
        System.out.println(Arrays.toString(array));
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int j: array) {
            arrayList.add(j);
        }
        List<int[]> aa = List.of(array);
        for (int[] ints: aa) {
            for (int anInt: ints) {
                System.out.println(anInt);
            }
        }
        System.out.println("ss");
        List<int[]> a = Collections.singletonList(array);
        for (int[] ints: aa) {
            for (int anInt: ints) {
                System.out.println(anInt);
            }
        }
        System.out.println("ss");
        Collections.swap(arrayList, 1, 10);
        for (Object next: arrayList) {
            System.out.println(next);
        }
        
        Arrays.fill(array, 99);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.equals(array, array));
        
        //时间api
        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt.getDayOfWeek());
        DayOfWeek dayOfWeek = DayOfWeek.of(4);
        System.out.println(dayOfWeek.minus(10));
        
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        result.add(0, list);
        result.add(1, list);
        for (List<Integer> integers: result) {
            for (Integer integer: integers) {
                System.out.printf("%d ", integer);
            }
        }
    }
    
    public static void 对象api() throws ParseException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object o = new Object();
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(Objects.equals(o, o1));
        System.out.println(Objects.hash(o, o1, o2));
        
        System.out.println(parseInt("1234", 16));
        NumberFormat s = NumberFormat.getNumberInstance();
        System.out.println(s.parse("10.11"));
        
        
        var name = "java.lang.Integer";
        Class<?> c = Class.forName(name);
        System.out.println(c);
        Object oo = c.getConstructor(int.class).newInstance(1);
        System.out.println(oo);
        
        int[] a = {1, 2, 3, 4, 5};
        Object newArray = Array.newInstance(a.getClass().getComponentType(), 10);
        //数组复制
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, 10));
        System.out.println(newArray);
        for (int i: (int[])newArray) {
            System.out.println(i);
        }
    }
    
    public static void 接口api() {
    
    }
    
}
